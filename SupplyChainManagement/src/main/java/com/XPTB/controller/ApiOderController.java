/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;


import com.XPTB.pojo.Detailimportorder;
import com.XPTB.pojo.Importorder;
import com.XPTB.pojo.Material;
import com.XPTB.repository.impl.ImportOderRepositoryImpl;
import com.XPTB.service.ImportOderDetailService;
import com.XPTB.service.ImportOderService;
import com.XPTB.service.MaterialService;
import com.XPTB.utils.StringUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author ADMIN
 */
@RestController
public class ApiOderController {
    @Autowired
    private ImportOderService ImportOder;
    @Autowired
    private MaterialService ma;
    @Autowired
    private ImportOderDetailService ImpDetail;

    @PostMapping(path = "/orders/add", consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> order(@RequestBody Map<String, Object> params) throws ParseException {
        Importorder i = new Importorder();
//        s.getTransaction().begin();
        Date DayE;
        try {
            DayE = StringUtils.getDateFormating().parse((String) params.get("expectDate"));
            Date DayD = StringUtils.getDateFormating().parse((String) params.get("deliveryDate"));
            
            Long totalCost = Long.parseLong((String) params.get("totalCost"));
            i.setDeliveryDate(DayD);
            i.setExpectDate(DayE);
            i.setActive(false);
            i.setTotalCost(totalCost);
            ImportOder.save(i);
            int Totalprice = 0;
            
            if(params.get("details") != null){
                
                List<Map<String, Object>> Details = (List<Map<String, Object>>) params.get("details");
                for (Map<String,Object> d :Details){
                    Detailimportorder D = new Detailimportorder();
                    D.setImportOderID(i);
                    int a= (int) d.get("quantity");
                    D.setQuantity(a);
                    Material m = ma.getMaterialById((int) d.get("materialId"));
                    D.setMaterialID(m);
                    D.setTotalAmount(Math.multiplyExact(m.getPrice(), a));  
                    ImpDetail.save(D);
                    Totalprice = (int) Math.addExact(Totalprice, D.getTotalAmount());
                }
            }
            i.setTotalPrice((long)Totalprice);
            ImportOder.save(i);
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(ImportOderRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

}
