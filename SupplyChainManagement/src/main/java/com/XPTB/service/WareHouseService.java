/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.pojo.Warehouse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface WareHouseService {

    public List<Warehouse> getAllWarehouses();

    public Warehouse getWarehouseById(int id);

    public void AddorUpdate(Warehouse w);

    public void Delete(int id);

    public List<Warehouse> getAllWarehouses(Map<String, String> params);

}
