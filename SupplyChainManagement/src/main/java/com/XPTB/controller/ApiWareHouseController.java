/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.DTO.WareHouseDTO;
import com.XPTB.pojo.Warehouse;
import com.XPTB.service.WareHouseService;
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
@RestController
public class ApiWareHouseController {
    @Autowired
    private WareHouseService w;
    
    @DeleteMapping("/warehouse/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        System.out.println(id);
        this.w.Delete(id);
    }
    @GetMapping("/api/warehouse")
    @CrossOrigin
    public ResponseEntity<?> getWareHouse(@RequestParam Map<String, String> params){
        List<Warehouse> warehouses = this.w.getAllWarehouses(params);
        List<WareHouseDTO> wDTO = new ArrayList<>();
        for(Warehouse wareH : warehouses){
            wDTO.add(new WareHouseDTO(wareH));
        }
        return new ResponseEntity<>(wDTO,HttpStatus.OK);
    }
    
}
