/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Manufacture;
import com.XPTB.service.ManufacetureService;
import com.XPTB.service.MaterialService;
import com.XPTB.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
public class ApiManufactureController {
    @Autowired
    ManufacetureService manufacture;
    @Autowired
    ProductService productService;
    @Autowired
    MaterialService materialService;
    
    @PostMapping(path = "/manufacture", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> AddManufacture(@RequestBody Map<String,Object> params){
        Manufacture manu = new Manufacture();
        try {
            if(params.get("materials") != null){
            List<Map<String,Object>> materials = (List<Map<String,Object>>) params.get("materials");
            for(Map<String, Object> details : materials){
                manu.setAmount((int) details.get("quantity"));
                manu.setMaterialId(this.materialService.getMaterialById((int) details.get("materialId")));
                manu.setProductId(this.productService.getProductById((int) params.get("productId")));
                this.manufacture.save(manu);
            }
        }
        } catch (Exception e) {
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
        
    }
    
}
