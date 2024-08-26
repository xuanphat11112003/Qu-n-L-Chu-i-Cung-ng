/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Warehouse;
import com.XPTB.repository.WareHouseRepository;
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
public class WareHouseRepositoryImpl implements WareHouseRepository{
    @Autowired
    private LocalSessionFactoryBean factory; 
    
    @Override
    public List<Warehouse> getAllWarehouses() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Warehouse.findAll");
        return q.getResultList();
    }

    @Override
    public Warehouse getWarehouseById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Warehouse.class, id);
    }

    @Override
    public void AddorUpdate(Warehouse w) {
        Session s = this.factory.getObject().getCurrentSession();
        if(w.getId()!=null)
            s.update(w);
        else
            s.save(w);
        
    }

    @Override
    public void Delete(int id) {
        Session s =this.factory.getObject().getCurrentSession();
        Warehouse w = this.getWarehouseById(id);
        s.delete(w);
    }

    @Override
    public List<Warehouse> getAllWarehouses(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Warehouse> q = b.createQuery(Warehouse.class);
        Root root = q.from(Warehouse.class);
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
