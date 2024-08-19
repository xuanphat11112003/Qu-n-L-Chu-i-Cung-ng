/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Inventory;
import com.XPTB.repository.InventoryRepository;
import com.XPTB.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository ivenInventory;

    @Override
    public void saveInventory(Inventory inventory) {
        this.ivenInventory.saveInventory(inventory);
    }
    
}
