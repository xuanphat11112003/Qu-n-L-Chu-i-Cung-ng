/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.DTO.MaterialDTO;
import com.XPTB.pojo.Material;
import com.XPTB.pojo.Materialstock;
import com.XPTB.repository.MaterialRepository;
import com.XPTB.service.MaterialService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class MaterialServiceImpl implements MaterialService{
    @Autowired
    private MaterialRepository maRepo;

    @Override
    public List<Material> getMaterials(Map<String, String> params) {
        return this.maRepo.getMaterials(params);
    }
    @Override
    public List<Material> getMaterials() {
        return this.maRepo.getMaterials();
    }


    @Override
    public Material getMaterialById(int id) {
        return this.maRepo.getMaterialById(id);
    }

    @Override
    public List<MaterialDTO> getMaterialsBySupplier(Map<String, String> params) {
        
       List<Material> m= this.maRepo.getMaterialsBySupplier(params);
       List<MaterialDTO> materialDTOs = new ArrayList<>();
       for (Material material : m ){
           materialDTOs.add(new MaterialDTO(material));
       }
       
       return materialDTOs;
    }

    @Override
    public Material getMaterialByName(String name) {
        return this.maRepo.getMaterialByName(name);
    }

    @Override
    public void AddorUpdate(Material mtrl) {
        this.maRepo.AddorUpdate(mtrl);
    }

    @Override
    public void deleteMaterial(int i) {
        this.maRepo.deleteMaterial(i);
    }

    
    
}
