/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Supplier;
import com.XPTB.repository.SupplierRepository;
import com.XPTB.service.SupplierService;
import java.util.List;
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
    
}
