/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Manufacture;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ManufactureRepository {
    List<Manufacture> getAllManufacture(Map<String,String> params);
    Manufacture getManufactureById(int id);
    public void save(Manufacture manu);
    public void delete(int id);
    List<Manufacture> getAllManufacture();
    
}
