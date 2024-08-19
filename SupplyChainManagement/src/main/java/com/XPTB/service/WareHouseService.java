/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.pojo.Warehouse;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface WareHouseService {
    public List<Warehouse> getAllWarehouses();
    public Warehouse getWarehouseById(int id);
}
