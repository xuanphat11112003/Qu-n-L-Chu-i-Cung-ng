/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Detailimportorder;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.XPTB.repository.ImportOderDetailsRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public class DetailImportOderRrepositoryImpl implements ImportOderDetailsRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public void saveimp(Detailimportorder di) {
        Session session = factory.getObject().getCurrentSession();
        session.save(di);
    }
    
}
