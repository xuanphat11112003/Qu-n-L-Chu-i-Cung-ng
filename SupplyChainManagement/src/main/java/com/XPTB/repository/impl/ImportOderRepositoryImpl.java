/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Importorder;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.XPTB.repository.ImportOderRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public class ImportOderRepositoryImpl implements ImportOderRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public void save(Importorder impoder) {
        Session s = factory.getObject().getCurrentSession();
        s.save(impoder);
    }
    
}
