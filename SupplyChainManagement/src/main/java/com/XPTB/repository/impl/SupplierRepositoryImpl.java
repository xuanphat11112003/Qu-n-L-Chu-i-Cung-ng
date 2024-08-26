/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Supplier;
import com.XPTB.repository.SupplierRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class SupplierRepositoryImpl implements SupplierRepository{
    @Autowired
    private LocalSessionFactoryBean f;
    
    @Override
    public List<Supplier> getAllSupplier() {
        Session s = f.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Supplier.findAll");
        return q.getResultList();
    }

    @Override
    public Supplier getSupplierByid(int id) {
        Session s = this.f.getObject().getCurrentSession();
        return s.get(Supplier.class, id);
        
    }

    @Override
    public void AddorUpdate(Supplier s) {
        Session a = this.f.getObject().getCurrentSession();
        if(s.getId()!=null)
            a.update(s);
        else
            a.save(s);
    }

    @Override
    public void Delete(int id) {
        Session s = this.f.getObject().getCurrentSession();
        Supplier a = this.getSupplierByid(id);
        s.delete(a);
    }

    @Override
    public List<Supplier> getAllSupplier(Map<String, String> params) {
        Session s = this.f.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Supplier> q = b.createQuery(Supplier.class);
        Root root = q.from(Supplier.class);
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
    
}
