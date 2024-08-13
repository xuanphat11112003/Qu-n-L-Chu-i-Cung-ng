/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.pojo.Material;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface MaterialService {
    List<Material> getMaterials();

    public Material getMaterialById(int id);

}
