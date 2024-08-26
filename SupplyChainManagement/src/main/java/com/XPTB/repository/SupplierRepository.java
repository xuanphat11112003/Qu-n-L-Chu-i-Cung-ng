/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Supplier;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface SupplierRepository {
    List<Supplier> getAllSupplier();
    public Supplier getSupplierByid(int id);
    public void AddorUpdate(Supplier s);
    public void Delete(int id);
    List<Supplier> getAllSupplier(Map<String,String> params);
    
    
}
