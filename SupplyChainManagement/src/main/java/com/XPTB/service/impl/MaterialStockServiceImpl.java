/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;


import com.XPTB.pojo.Materialstock;
import com.XPTB.repository.MaterialRepository;
import com.XPTB.repository.MaterialStockRepository;

import com.XPTB.service.MaterialStockService;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<Object[]> getAllMaterialStock(Map<String, String> map) {
        return this.materialRepo.getAllMaterialStock(map);
    }

    @Override
    public void Delete(int i) {
        this.materialRepo.Delete(i);
    }

    @Override
    public Materialstock getMaterialstockById(int i) {
        return this.materialRepo.getMaterialstockById(i);
    }

    @Override
    public void update(Materialstock m) {
        this.materialRepo.updateExpireDate(m);
    }

    @Override
    public void updateQuantity(Materialstock ms) {
        this.materialRepo.updateQuantity(ms);
    }

    
    
}
