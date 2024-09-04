/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.DTO.ManufactureDTO;
import com.XPTB.pojo.Manufacture;
import com.XPTB.service.ManufacetureService;
import com.XPTB.service.MaterialService;
import com.XPTB.service.ProductService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/manufacture")
public class ManufacetureController {
    
    @Autowired
    private ManufacetureService manu;
    @Autowired
    private ProductService pro;
    @Autowired
    private MaterialService mat;
    
    @RequestMapping("/index")
    public String indexManufacture(Model model, @RequestParam Map<String, String> params){
        List<Manufacture> manufacture = this.manu.getManufacture(params);
        Map<String, List<Map<String,Object>>> grouMap = new HashMap<>();
        for(Manufacture m : manufacture){
            String name = m.getProductId().getName();
            Map<String,Object> listDetail = new HashMap<>();
            listDetail.put("material",m.getMaterialId().getName());
            listDetail.put("amout", m.getAmount());
            if(!grouMap.containsKey(name)){
                List<Map<String, Object>> detailsList = new ArrayList<>();
                grouMap.put(name, detailsList);
            }
            grouMap.get(name).add(listDetail);
        }
        model.addAttribute("gruop",grouMap);
        return "indexManufacture";
    }
    @RequestMapping("/add")
    public String addManufacture(Model model, @RequestParam Map<String, String> params){
        List<ManufactureDTO> manu = this.manu.getAllManufacture(params);
        System.out.println("Manufactures: " + manu);
        model.addAttribute("product", this.pro.getListProducts());
        model.addAttribute("material", this.mat.getMaterials(params));
        model.addAttribute("manufacture", this.manu.getManufacture());
        
        return "addManufacture";
    }
    
}
