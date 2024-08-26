/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Material;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface MaterialRepository {
    List<Material> getMaterials(Map<String, String> params);
    public Material getMaterialById(int id);
    public Material getMaterialByName(String name);
    List<Material> getMaterialsBySupplier(Map<String, String> params);
    public void AddorUpdate(Material ma);
    List<Material> getMaterials();
    public void deleteMaterial(int id);

}
