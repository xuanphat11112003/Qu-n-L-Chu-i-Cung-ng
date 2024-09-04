/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Inventory;
import com.XPTB.pojo.Product;
import com.XPTB.pojo.Productstock;
import com.XPTB.pojo.Warehouse;
import com.XPTB.repository.ProductStockRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class ProductStockRepositoryImpl implements ProductStockRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> getAllProductStock(Map<String,String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = b.createQuery(Object[].class);
        Root<Productstock> root = cq.from(Productstock.class);
        Join<Productstock, Product> joinProduct = root.join("product");
        Join<Productstock, Inventory> joinInventory = root.join("inventory");
        Join<Inventory,Warehouse> joinWarehouse = joinInventory.join("warehouse");
        cq.multiselect(
                b.sum(root.get("amount").as(Integer.class)),
                joinProduct.get("id"),
                joinProduct.get("name"),
                joinWarehouse.get("id"),
                joinWarehouse.get("name")        
        );
        cq.groupBy(joinProduct.get("id"),
                joinProduct.get("name"),
                joinWarehouse.get("id"),
                joinWarehouse.get("name")  );
        
        List<Predicate> predicates = new ArrayList<>();
        if(params != null && !params.isEmpty()){
            String status = params.get("name");
            if(status != null && !status.isEmpty())
                predicates.add(b.like(joinProduct.get("name").as(String.class), status));
            cq.where(predicates.toArray(new Predicate[0]));
        }
        Query<Object[]> query = s.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void save(Productstock proS) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Productstock> cq = b.createQuery(Productstock.class);
        Root<Productstock> root = cq.from(Productstock.class);
        cq.select(root)
                .where(b.equal(root.get("product"), proS.getProduct().getId() ),
                        b.equal(root.get("inventory").get("entryDate"), proS.getInventory().getEntryDate()),
                        b.equal(root.get("inventory").get("warehouse").get("name"), proS.getInventory().getWarehouse().getName()));
        List<Productstock> result = s.createQuery(cq).getResultList();
        if(result.isEmpty()){
            s.save(proS);
        }else{
            Productstock productstock = result.get(0);
            productstock.setQuantity(productstock.getQuantity() + proS.getQuantity());
            s.update(productstock);
        }
    }

    @Override
    public void delete(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Productstock pros= this.getProductstockById(id);
        s.delete(pros);
    }

    @Override
    public Productstock getProductstockById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Productstock.class, id);
    }

   
    
}
