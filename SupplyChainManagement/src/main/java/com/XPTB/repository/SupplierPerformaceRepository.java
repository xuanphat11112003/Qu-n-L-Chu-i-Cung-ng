/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Supplierperformance;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface SupplierPerformaceRepository {
    public void save(Supplierperformance s);
    List<Supplierperformance> getAllRate(Map<String, String> params);
    List<Object[]> Stats(Map<String, String> params);
    List<Object[]> StatsByM(Map<String, String> params);
}
