/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Inventory;
import com.XPTB.repository.InventoryRepository;
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
public class InventoryRepositoryImpl implements InventoryRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void saveInventory(Inventory inventory) {

        Session s = factory.getObject().getCurrentSession();
        if (inventory.getId() == null) {
            s.save(inventory);
        } else {
            s.update(inventory);
        }
    }

}
