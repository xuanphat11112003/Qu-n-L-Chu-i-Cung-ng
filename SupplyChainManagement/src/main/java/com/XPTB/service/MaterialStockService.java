/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.pojo.Materialstock;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface MaterialStockService {
    public void addMaterialinStock(Materialstock material);
    public List<Object[]> getAllMaterialStock(Map<String,String> params);
    public void Delete(int id);
    public Materialstock getMaterialstockById(int id);
    public void update(Materialstock ms );
    public void updateQuantity(Materialstock ms);
}
