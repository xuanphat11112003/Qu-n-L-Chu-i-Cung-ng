package com.XPTB.repository.impl;


import com.XPTB.pojo.Material;
import com.XPTB.repository.MaterialRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class MaterialRepositoryImpl implements MaterialRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Material> getMaterials() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Material.findAll");
        return q.getResultList();
    }


    @Override
    public Material getMaterialById(int id) {
        Session  s = this.factory.getObject().getCurrentSession();
        return s.get(Material.class,id);
    }

    @Override
    public List<Material> getMaterialsBySupplier(Map<String, String> params) {
        int id = Integer.parseInt(params.get("q"));
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Material> cm = cb.createQuery(Material.class);
        Root<Material> ma = cm.from(Material.class);
        Predicate p = cb.equal(ma.get("supplierId"), id);
        cm.where(p);
        Query query = s.createQuery(cm);
        return query.getResultList();
        
    }

    @Override
    public Material getMaterialByName(String name) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Material.findByName");
        q.setParameter("name", name);
        return (Material) q.getSingleResult();
    }

}
