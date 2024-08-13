/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Material;
import com.XPTB.repository.MaterialRepository;
import com.XPTB.service.MaterialService;
import java.util.List;
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
    public List<Material> getMaterials() {
        return this.maRepo.getMaterials();
    }
<<<<<<< HEAD

    @Override
    public Material getMaterialById(int id) {
        return this.maRepo.getMaterialById(id);
    }
=======
>>>>>>> 73f473402519512d283afc13ec32a081b94a2390
    
    
}
