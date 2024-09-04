/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.DTO.ManufactureDTO;
import com.XPTB.pojo.Manufacture;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ManufacetureService {
    List<ManufactureDTO> getAllManufacture(Map<String,String> params);
    ManufactureDTO getManufactureById(int id);
    public void save(Manufacture manu);
    public void delete(int id);
    List<Manufacture> getManufacture(Map<String,String> params);
    Manufacture getManufactureId(int id);
    List<Manufacture> getManufacture();
    
}
