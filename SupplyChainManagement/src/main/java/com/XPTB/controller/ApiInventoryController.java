/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Inventory;
import com.XPTB.pojo.Productstock;
import com.XPTB.service.InventoryService;
import com.XPTB.service.ProductService;
import com.XPTB.service.ProductStockService;
import com.XPTB.service.WareHouseService;
import com.XPTB.utils.StringUtils;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
public class ApiInventoryController {

    @Autowired
    private ProductStockService proService;
    @Autowired
    private WareHouseService wareService;
    @Autowired
    private ProductService product;
    @Autowired
    private InventoryService inv;

    @PostMapping("/ProductStock")
    public ResponseEntity<?> addProductStock(@RequestBody Map<String, Object> params) throws ParseException {
        try {
            Inventory inv = new Inventory();
            Date d = StringUtils.getDateFormating().parse((String) params.get("entryDate"));
            inv.setWarehouse(this.wareService.getWarehouseById((int) params.get("warehouse")));
            inv.setEntryDate(d);
            this.inv.saveInventory(inv);
            Productstock pros = new Productstock();
            d = StringUtils.getDateFormating().parse((String) params.get("expireDate"));
            pros.setDateExpire(d);
            pros.setQuantity((int) params.get("quantity"));
            pros.setInventory(inv);
            pros.setProduct(this.product.getProductById((int) params.get("productId")));
            this.proService.save(pros);

        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
