/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.DTO.PerformanceSupplierDTO;
import com.XPTB.pojo.Supplier;
import com.XPTB.pojo.Supplierperformance;
import com.XPTB.service.ImportOderService;
import com.XPTB.service.SupplierPerformanceService;
import com.XPTB.service.SupplierService;
import com.XPTB.utils.StringUtils;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
public class ApiSupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ImportOderService ImportOderService;
    @Autowired
    private SupplierPerformanceService supplierPerformanceService;
    
    @DeleteMapping("/supplier/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
     public void delete(@PathVariable(value = "id") int id) {
        System.out.println(id);
        this.supplierService.Delete(id);
    }
     
    @PostMapping(path = "/supplier/evaluate/id/{oid}/{sid}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addEvaluate(@RequestBody PerformanceSupplierDTO performanceSupplierDTO,
            @PathVariable(value = "oid") int oid,
            @PathVariable(value = "sid") int sid){
        
        try{
            performanceSupplierDTO.setSupplier(sid);
            
            performanceSupplierDTO.setImportorder(oid);
            this.supplierPerformanceService.save(performanceSupplierDTO);
            return new ResponseEntity<>(performanceSupplierDTO,HttpStatus.CREATED);
            
        }catch(Exception ex){
             return new ResponseEntity<>("Error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    
}
