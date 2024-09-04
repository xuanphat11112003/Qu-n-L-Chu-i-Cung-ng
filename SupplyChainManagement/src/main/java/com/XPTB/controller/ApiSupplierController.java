/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.DTO.PerformanceSupplierDTO;
import com.XPTB.DTO.SupplierDTO;
import com.XPTB.pojo.Supplier;
import com.XPTB.pojo.Supplierperformance;
import com.XPTB.service.ImportOderService;
import com.XPTB.service.SupplierPerformanceService;
import com.XPTB.service.SupplierService;
import com.XPTB.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/api/supplier")
    @CrossOrigin
    public ResponseEntity<List<SupplierDTO>> getSupplier(@RequestParam Map<String, String> params){
        List<Supplier> sup = this.supplierService.getAllSupplier(params);
        List<SupplierDTO> supDTO = new ArrayList<>();
            for(Supplier s : sup){
                supDTO.add(new SupplierDTO(s));
            }
        return new ResponseEntity<>(supDTO,HttpStatus.OK);
    }
    @PostMapping(path = "/api/supplier/evaluate/{oid}/{sid}",consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<?> addEvaluate1(@RequestBody PerformanceSupplierDTO performanceSupplierDTO,
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
    @GetMapping("/api/supplier/evaluate")
    @CrossOrigin
    public ResponseEntity<?> getEvaluateOfSupplier(@RequestParam Map<String, String> params){
        List<PerformanceSupplierDTO> pDTO = this.supplierPerformanceService.performanceSupplierDTOs(params);
        Map<Integer,List<PerformanceSupplierDTO>> groupMap = new HashMap<>();
        for(PerformanceSupplierDTO p : pDTO){
            int id = p.getSupplier();
            if(!groupMap.containsKey(id))
                groupMap.put(id,new ArrayList<PerformanceSupplierDTO>());
            groupMap.get(id).add(p);
        }
        return new ResponseEntity<>(groupMap,HttpStatus.OK);
    }
    @GetMapping("api/supplier/rate")
    @CrossOrigin
    public ResponseEntity<?> getRateSupplier(@RequestParam Map<String, String> params){
        return new ResponseEntity<>(this.supplierPerformanceService.Stats(params),HttpStatus.OK);
    }
}
