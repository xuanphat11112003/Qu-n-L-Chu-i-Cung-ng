/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Supplier;
import com.XPTB.repository.SupplierRepository;
import java.util.List;
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
    
}
