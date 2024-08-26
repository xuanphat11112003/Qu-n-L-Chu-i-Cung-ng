/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Supplier;
import com.XPTB.repository.SupplierRepository;
import com.XPTB.service.SupplierService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierRepository supRepo;
    
    @Override
    public List<Supplier> getAllSupplier() {
        return this.supRepo.getAllSupplier();
    }

    @Override
    public Supplier getSupplierByid(int id) {
        return this.supRepo.getSupplierByid(id);
    }

    @Override
    public void AddorUpdate(Supplier s) {
        this.supRepo.AddorUpdate(s);
    }

    @Override
    public void Delete(int id) {
        this.supRepo.Delete(id);
    }

    @Override
    public List<Supplier> getAllSupplier(Map<String, String> params) {
        return this.supRepo.getAllSupplier(params);
    }
    
}
