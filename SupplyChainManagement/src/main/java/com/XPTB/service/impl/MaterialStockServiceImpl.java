/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;


import com.XPTB.pojo.Materialstock;
import com.XPTB.repository.MaterialRepository;
import com.XPTB.repository.MaterialStockRepository;

import com.XPTB.service.MaterialStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ADMIN
 */
@Service
public class MaterialStockServiceImpl implements MaterialStockService{
    @Autowired
    private MaterialStockRepository materialRepo; 
    
    @Override
    public void addMaterialinStock(Materialstock material) {
        this.materialRepo.addMaterialinStock(material);
    }

    
    
}
