/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Warehouse;
import com.XPTB.repository.WareHouseRepository;
import com.XPTB.service.WareHouseService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class WareHouseServiceImpl implements WareHouseService{
    @Autowired
    private WareHouseRepository wareHouseRepo;
    
    @Override
    public List<Warehouse> getAllWarehouses() {
        return this.wareHouseRepo.getAllWarehouses();
    }

    @Override
    public Warehouse getWarehouseById(int id) {
        return this.wareHouseRepo.getWarehouseById(id);
    }

    @Override
    public void AddorUpdate(Warehouse w) {
        this.wareHouseRepo.AddorUpdate(w);
    }

    @Override
    public void Delete(int id) {
        this.wareHouseRepo.Delete(id);
    }

    @Override
    public List<Warehouse> getAllWarehouses(Map<String, String> params) {
        return this.wareHouseRepo.getAllWarehouses(params);
    }
    
}
