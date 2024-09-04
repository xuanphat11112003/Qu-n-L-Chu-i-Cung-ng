/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Manufacture;
import com.XPTB.repository.ManufactureRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import jdk.internal.org.jline.utils.Colors;
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
public class ManufactureRepositoryImpl implements ManufactureRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Manufacture> getAllManufacture(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Manufacture> cq = b.createQuery(Manufacture.class);
        Root root = cq.from(Manufacture.class);
        cq.select(root);
        if(params!=null && !params.isEmpty()){
            String ProductId = params.get("proID");
            if(ProductId != null && !ProductId.isEmpty()){
                Predicate p1  = b.equal(root.get("productId").get("id"), ProductId);
                cq.where(p1);
            }
        }
        Query query =s.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Manufacture getManufactureById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Manufacture.class, id);
    }

    @Override
    public void save(Manufacture manu) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(manu);
    }

    @Override
    public void delete(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getManufactureById(id));
    }

    @Override
    public List<Manufacture> getAllManufacture() {
        Session s =this.factory.getObject().getCurrentSession();
        Query query = s.createNamedQuery("Manufacture.findAll");
        return query.getResultList();
    }
    
}
