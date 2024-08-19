/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.DTO.MaterialDTO;
import com.XPTB.pojo.Detailimportorder;
import com.XPTB.pojo.Importorder;
import com.XPTB.pojo.Importorder.Payment;
import com.XPTB.pojo.Inventory;
import com.XPTB.pojo.Material;
import com.XPTB.pojo.Materialstock;
import com.XPTB.repository.impl.ImportOderRepositoryImpl;
import com.XPTB.service.ImportOderDetailService;
import com.XPTB.service.ImportOderService;
import com.XPTB.service.InventoryService;
import com.XPTB.service.MaterialService;
import com.XPTB.service.MaterialStockService;
import com.XPTB.service.WareHouseService;
import com.XPTB.utils.StringUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author ADMIN
 */
@RequestMapping("/api")
@RestController
public class ApiOderController {

    @Autowired
    private ImportOderService ImportOder;
    @Autowired
    private MaterialService ma;
    @Autowired
    private ImportOderDetailService ImpDetail;
    @Autowired
    private WareHouseService wareHouse;
    @Autowired
    private InventoryService inventory;
    @Autowired
    private MaterialStockService materialStock;

    @PostMapping(path = "/orders/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> order(@RequestBody Map<String, Object> params) throws ParseException {
        Importorder i = new Importorder();
//        s.getTransaction().begin();
        Date DayE;
        try {
            DayE = StringUtils.getDateFormating().parse((String) params.get("expectDate"));
            Date DayD = StringUtils.getDateFormating().parse((String) params.get("deliveryDate"));

            String payment = (String) params.get("payment");
            Payment p = StringUtils.fromString(payment);
            i.setDeliveryDate(DayD);
            i.setExpectDate(DayE);
            i.setActive(false);
            i.setPayment(StringUtils.toString(p));
            ImportOder.save(i);
            int Totalprice = 0;

            if (params.get("details") != null) {

                List<Map<String, Object>> Details = (List<Map<String, Object>>) params.get("details");
                for (Map<String, Object> d : Details) {
                    Detailimportorder D = new Detailimportorder();
                    D.setImportOderID(i);
                    int a = (int) d.get("quantity");
                    D.setQuantity(a);
                    Material m = ma.getMaterialById((int) d.get("materialId"));
                    D.setMaterialID(m);
                    D.setTotalAmount(Math.multiplyExact(m.getPrice(), a));
                    ImpDetail.save(D);
                    Totalprice = (int) Math.addExact(Totalprice, D.getTotalAmount());
                }
            }
            i.setTotalPrice((long) Totalprice);
            ImportOder.save(i);

        } catch (ParseException ex) {
            Logger.getLogger(ImportOderRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/getMaterialsBySupplier")
    public ResponseEntity<List<MaterialDTO>> getMaterialsBySupplier(@RequestParam Map<String, String> params) {
        List<MaterialDTO> m = this.ma.getMaterialsBySupplier(params);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @PostMapping(path = "/updateStatus", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> AcceptOrder(@RequestBody Map<String, Object> params) {
        int id = Integer.parseInt((String) params.get("orderid"));
        Materialstock mStock = new Materialstock();
        try {
            this.ImportOder.UpdateActive(id);
            Inventory inv = new Inventory();
            Date DayD = StringUtils.getDateFormating().parse((String) params.get("entryDate"));
            inv.setEntryDate(DayD);
            inv.setWarehouse(this.wareHouse.getWarehouseById(Integer.parseInt((String) params.get("warehouse"))));
            List<Object[]> detailorder = this.ImpDetail.getDetailOrder(null);
            this.inventory.saveInventory(inv);
            for (Object[] detail : detailorder) {
                if ((int) detail[0] == id) {                  
                    String name = (String) detail[1];
                    long p = (long) detail[2];
                    mStock.setMaterialId(this.ma.getMaterialByName(name));
                    mStock.setAmount((int) p);
                    mStock.setInventory(inv);
                    this.materialStock.addMaterialinStock(mStock);
                }

            }
            
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
