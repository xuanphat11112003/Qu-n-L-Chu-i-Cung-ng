/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Inventory;
import com.XPTB.pojo.Material;
import com.XPTB.pojo.Materialstock;
import com.XPTB.pojo.Warehouse;
import com.XPTB.repository.MaterialStockRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class MaterialStockRepositoryImpl implements MaterialStockRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void addMaterialinStock(Materialstock material) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Materialstock> cq = cb.createQuery(Materialstock.class);
        Root<Materialstock> root = cq.from(Materialstock.class);

        cq.select(root)
                .where(cb.equal(root.get("materialId"), material.getMaterialId()),
                        cb.equal(root.get("inventory").get("entryDate"), material.getInventory().getEntryDate()),
                        cb.equal(root.get("inventory").get("warehouse").get("name"), material.getInventory().getWarehouse().getName())
                );

        List<Materialstock> results = s.createQuery(cq).getResultList();
        if (results.isEmpty()) {
            s.save(material);
        } else {
            Materialstock existingStock = results.get(0);
            existingStock.setAmount(existingStock.getAmount() + material.getAmount());
            s.update(existingStock);
        }
    }

    @Override
    public List<Object[]> getAllMaterialStock(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = b.createQuery(Object[].class);
        Root<Materialstock> root = cq.from(Materialstock.class);
        Join<Materialstock, Material> materialjoin = root.join("materialId");
        Join<Materialstock, Inventory> inventoryJoin = root.join("inventory");
        Join<Inventory, Warehouse> wareHousejoin = inventoryJoin.join("warehouse");
        cq.multiselect(
                b.sum(root.get("amount").as(Integer.class)),
                materialjoin.get("id"),
                materialjoin.get("name"),
                wareHousejoin.get("id"),
                wareHousejoin.get("name")
        );
        cq.groupBy(materialjoin.get("name"), materialjoin.get("id"),
                wareHousejoin.get("id"), wareHousejoin.get("name"));
        List<Predicate> predicates = new ArrayList<>();
        if (params != null && !params.isEmpty()) {
            String status = params.get("name");
            if (status != null) {
                predicates.add(b.like(materialjoin.get("name").as(String.class), status));
            }
            cq.where(predicates.toArray(new Predicate[0]));
        }
        Query<Object[]> query = s.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void Delete(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Materialstock ms = this.getMaterialstockById(id);
        if (ms != null) {
            Inventory inv = ms.getInventory();
            s.delete(s);
            s.flush();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<Materialstock> root = cq.from(Materialstock.class);
            cq.select(cb.count(root))
                    .where(cb.equal(root.get("inventory"), inv));
            Long count = s.createQuery(cq).getSingleResult();
            if (count == 0) {
                s.delete(inv);
            }
        }

    }

    @Override
    public Materialstock getMaterialstockById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Materialstock.class, id);
    }

    @Override
    public void updateExpireDate(Materialstock m) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(s);
    }

    @Override
    public void updateQuantity(Materialstock m) {
        Session s = null;
        try {
            s = this.factory.getObject().getCurrentSession();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Materialstock> cq = cb.createQuery(Materialstock.class);
            Root<Materialstock> root = cq.from(Materialstock.class);
            cq.select(root)
                    .where(cb.equal(root.get("materialId"), m.getMaterialId()))
                    .orderBy(cb.asc(root.get("inventory").get("entryDate")));
            List<Materialstock> stocks = s.createQuery(cq).getResultList();

            int amountToSubtract = m.getAmount();
            for (Materialstock stock : stocks) {
                int currentAmount = stock.getAmount();
                if (currentAmount >= amountToSubtract) {
                    stock.setAmount(currentAmount - amountToSubtract);
                    int so = stock.getAmount();
                    if(so == 0)
                        this.Delete(stock.getId());
                    else
                        s.update(stock);
                    amountToSubtract = 0;
                    break;
                } else {
                    amountToSubtract -= currentAmount;
                    this.Delete(stock.getId());
                }
            }

            if (amountToSubtract > 0) {
                throw new RuntimeException("Không đủ vật liệu để sản xuất");
            }

        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi cập nhật số lượng: " + e.getMessage(), e);
        }
    }

}
