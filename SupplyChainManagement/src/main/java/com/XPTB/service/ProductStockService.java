/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.pojo.Productstock;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ProductStockService {
    public List<Object[]> getAllProductStock(Map<String,String> params);
    public void save(Productstock proS);
    public void delete(int id);
    public Productstock getProductstockById(int id);
}
