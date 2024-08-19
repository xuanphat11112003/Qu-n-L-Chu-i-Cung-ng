/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Warehouse;
import com.XPTB.repository.WareHouseRepository;
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
    
}
