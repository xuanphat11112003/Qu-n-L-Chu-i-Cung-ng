/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Agency;
import com.XPTB.pojo.Detailimportorder;
import com.XPTB.pojo.Importorder;
import com.XPTB.pojo.Material;
import com.XPTB.pojo.Supplier;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.XPTB.repository.ImportOderDetailsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class DetailImportOderRrepositoryImpl implements ImportOderDetailsRepository {
    

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void saveimp(Detailimportorder di) {
        Session session = factory.getObject().getCurrentSession();
        session.save(di);
    }

    @Override
    public List<Object[]> getDetailOrder(Map<String, String> params) {
        // Lấy session từ factory
        Session session = this.factory.getObject().getCurrentSession();

        // Tạo CriteriaBuilder và CriteriaQuery
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        // Định nghĩa các bảng
        Root<Importorder> importOrder = cq.from(Importorder.class);
        Join<Importorder, Detailimportorder> detailOrderJoin = importOrder.join("detailimportorderCollection");
        Join<Detailimportorder, Material> materialJoin = detailOrderJoin.join("materialID");
        Join< Material, Supplier> supplierJoin = materialJoin.join("supplierId");
//        Expression<Long> productExpression = cb.prod(
//                detailOrderJoin.get("quantity").as(Long.class),
//                materialJoin.get("price").as(Long.class)
//        );
//        Expression<Long> totalValue = cb.sum(productExpression);
        // Chọn các trường cần thiết và thực hiện phép toán nếu cần
        cq.multiselect(
                importOrder.get("id"), // ID của Importorder 0
                materialJoin.get("name"),// Tên của Material 1
                cb.sum(detailOrderJoin.get("quantity").as(Integer.class)), // 2 Số lượng từ Detailimportorder
                importOrder.get("totalPrice"),//3
                importOrder.get("expectDate"),//4
                importOrder.get("deliveryDate"),//5
                importOrder.get("active"),//6
                supplierJoin.get("name"),//7
                supplierJoin.get("address"),//8
                supplierJoin.get("phone"),//9
                importOrder.get("activeEvaluate"),//10
                supplierJoin.get("id")//11

        );

        // Nếu cần nhóm dữ liệu
        cq.groupBy(importOrder.get("id"), materialJoin.get("name"), supplierJoin.get("name"),
                supplierJoin.get("address"), supplierJoin.get("phone"),supplierJoin.get("id"));
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String id = params.get("q");
            if (id != null && !id.isEmpty()) {
                predicates.add(cb.equal(importOrder.get("id"), id));
            }
            // Lọc theo ngày dự kiến
            String date = params.get("dateFilter");
            if (date != null && !date.isEmpty()) {
                if (date.equals("latest")) {
                    cq.orderBy(cb.desc(importOrder.get("expectDate")));
                } else if (date.equals("oldest")) {
                    cq.orderBy(cb.asc(importOrder.get("expectDate")));
                }
            }

            // Lọc theo trạng thái
            String status = params.get("confirmationFilter");
            if (status != null && !status.isEmpty()) {
                if (status.equals("confirmed")) {
                    predicates.add(cb.equal(importOrder.get("active"), true));
                } else if (status.equals("unconfirmed")) {
                    predicates.add(cb.equal(importOrder.get("active"), false));
                }
            }
            String content = params.get("evaluate");
            if(content != null && !content.isEmpty()){
                if (content.equals("confirmed")) {
                    predicates.add(cb.equal(importOrder.get("activeEvaluate"), true));
                } else if (content.equals("unconfirmed")) {
                    predicates.add(cb.equal(importOrder.get("activeEvaluate"), false));
                }
            }
            cq.where(predicates.toArray(new Predicate[0] ));
        }
        // Tạo truy vấn và thực thi
        Query<Object[]> query = session.createQuery(cq);
        return query.getResultList();
    }

}
