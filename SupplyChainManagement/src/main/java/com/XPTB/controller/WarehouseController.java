/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Warehouse;
import com.XPTB.service.WareHouseService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WareHouseService wareHouseService;
    
    @RequestMapping("/index")
    public String indexWareHouse(Model model,@RequestParam Map<String, String> params){
        model.addAttribute("warehouse", this.wareHouseService.getAllWarehouses(params));
        return "indexwarehouse";
    }
     @GetMapping("/add")
    public String SeeAddMaterial(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "addwarehouse";
    }

    @PostMapping("/add")
    public String AddMaterial(Model model,
            @ModelAttribute(value = "warehouse") @Valid Warehouse p,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "addwarehouse";
        }
        try {
            this.wareHouseService.AddorUpdate(p);
            return"redirect:/warehouse/index";
        } catch (Exception e) {
            model.addAttribute("errMsg", e.getMessage());
        }
        return "addwarehouse";
    }
    @GetMapping("/add/{materialId}")
    public String detailsView(Model model, @PathVariable(value = "materialId") int id) {
        model.addAttribute("warehouse", this.wareHouseService.getWarehouseById(id));
        return "addwarehouse";
    }
    
}
