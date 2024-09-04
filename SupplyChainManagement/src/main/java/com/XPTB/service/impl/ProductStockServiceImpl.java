/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Manufacture;
import com.XPTB.pojo.Materialstock;
import com.XPTB.pojo.Productstock;
import com.XPTB.repository.ManufactureRepository;
import com.XPTB.repository.MaterialRepository;
import com.XPTB.repository.MaterialStockRepository;
import com.XPTB.repository.ProductStockRepository;
import com.XPTB.service.ProductStockService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ProductStockServiceImpl implements ProductStockService{
    @Autowired
    private ProductStockRepository prosRepo;
    @Autowired
    private ManufactureRepository manuRepo;
    @Autowired
    private MaterialStockRepository masRepo;

    @Override
    public List<Object[]> getAllProductStock(Map<String, String> params) {
        return this.prosRepo.getAllProductStock(params);
    }

    @Override
    public void save(Productstock proS) {
        Map<String,String> params = new HashMap<>();
        int id = proS.getProduct().getId();
        params.put("proID", String.valueOf(id) );
        List<Manufacture> manufac  = this.manuRepo.getAllManufacture(params);
        for(Manufacture manu : manufac){
            Materialstock materialstock = new Materialstock();
            materialstock.setMaterialId(manu.getMaterialId());
            materialstock.setAmount(manu.getAmount() * proS.getQuantity());
            materialstock.setInventory(proS.getInventory());
            this.masRepo.updateQuantity(materialstock);
        }
        this.prosRepo.save(proS);
    }

    @Override
    public void delete(int id) {
        this.prosRepo.delete(id);
    }

    @Override
    public Productstock getProductstockById(int id) {
        return this.prosRepo.getProductstockById(id);
    }
    
}
