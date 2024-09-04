/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.service.MaterialStockService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.nio.cs.MS874;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private MaterialStockService ms;

    @GetMapping("/index")
    public String addInventory(Model model) {
        return "viewInventory";
    }
    @GetMapping("/materialStock/detail")
    public String indexMaterialStock(Model model,@RequestParam Map<String,String> params){
        model.addAttribute("materialStock", this.ms.getAllMaterialStock(params));
        return "seeMaterialStock";
    }
   

}
