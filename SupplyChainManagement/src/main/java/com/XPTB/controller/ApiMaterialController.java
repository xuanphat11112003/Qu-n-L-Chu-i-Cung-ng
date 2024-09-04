/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.DTO.MaterialDTO;
import com.XPTB.pojo.Material;
import com.XPTB.service.MaterialService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RequestMapping("/api")
@RestController
@CrossOrigin
public class ApiMaterialController {
    @Autowired
    private MaterialService ma;
    
    @DeleteMapping("/material/{materialid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "materialid") int id) {
        System.out.println(id);
        this.ma.deleteMaterial(id);
    }
    @GetMapping("/material")
    public ResponseEntity<List<MaterialDTO>> GetMaterial(@RequestParam Map<String, String> params){
        List<Material> material = this.ma.getMaterials(params);
        List<MaterialDTO> maDTO = new ArrayList<>();
        for(Material m : material){
            maDTO.add(new MaterialDTO(m));
        }
        return new ResponseEntity<>(maDTO,HttpStatus.OK);
    }
    
}
