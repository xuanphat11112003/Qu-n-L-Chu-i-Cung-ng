/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Materialprice;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface MaterialPriceRepository {
    public void save(Materialprice mp);
    public void delete(int id);
    public Materialprice getMaterialpriceByID(int id);
    public List<Materialprice> getAllMaterialPrice(Map<String,String> params);
    
}
