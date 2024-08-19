/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Material;
import com.XPTB.pojo.Materialstock;
import com.XPTB.repository.MaterialStockRepository;
import org.hibernate.Session;
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
public class MaterialStockRepositoryImpl implements MaterialStockRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void addMaterialinStock(Materialstock material) {
        Session s = factory.getObject().getCurrentSession();
        if(material.getId() == null){
            s.save(material);
        }else{
            s.update(material);
        }
    }
    
}
