/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Product;
import com.XPTB.repository.ProductRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import javax.persistence.Query;
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
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Product> getListProducts(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);
        if (params != null) {
            String name = params.get("q");
            if(name != null){
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", name));
                q.where(p1);
            }
            
        }
        Query query = s.createQuery(q);
        return query.getResultList();
        
    }

    @Override
    public void addOrUpdate(Product p) {
        Session s = this.factory.getObject().getCurrentSession();
        if (p.getId() != null) {
            s.update(p);
        } else {
            s.save(p);
        }
    }
    @Override
    public Product getProductById(int i) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Product.class, i);
    }

    @Override
    public void deleteProduct(int id) {
        Session s =this.factory.getObject().getCurrentSession();
        Product p = this.getProductById(id);
        s.delete(p);
    }

    

}
