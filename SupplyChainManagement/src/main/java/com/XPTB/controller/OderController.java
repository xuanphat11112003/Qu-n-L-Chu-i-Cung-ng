/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Agency;
import com.XPTB.pojo.Detailimportorder;
import com.XPTB.pojo.Importorder.Payment;
import com.XPTB.pojo.Material;
import com.XPTB.pojo.Supplier;
import com.XPTB.pojo.Warehouse;
import com.XPTB.service.ImportOderDetailService;
import com.XPTB.service.ImportOderService;
import com.XPTB.service.MaterialService;
import com.XPTB.service.SupplierService;
import com.XPTB.service.WareHouseService;
import com.XPTB.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/orders")
public class OderController {
    @Autowired
    private SupplierService sup;

    @Autowired
    private MaterialService material;
    
    @Autowired
    private ImportOderDetailService orderService;
    
    @Autowired
    private WareHouseService WareHouseService;
    @GetMapping("")
    public String ShowImportOrder(Model model,@RequestParam Map<String,String> params){
        List<Warehouse> wareHouse = WareHouseService.getAllWarehouses();
        List<Object[]> orderDetails = orderService.getDetailOrder(params);
        Map<Integer, List<Object[]>> groupedOrderDetails = new HashMap<>();
        List<Agency> a = new ArrayList<>();
        for (Object[] detail : orderDetails) {
            int orderId =  (int) detail[0]; // ID của Importorder
            if (!groupedOrderDetails.containsKey(orderId)) {
                groupedOrderDetails.put(orderId, new ArrayList<Object[]>());
            }
            groupedOrderDetails.get(orderId).add(detail);
        }
        model.addAttribute("groupedOrderDetails", groupedOrderDetails);
        model.addAttribute("warehouse",wareHouse);
        return "seeorder";
    }

    @GetMapping("/add")
    public String showCreateOrderForm(Model model) {
        List<String> p = new ArrayList<>();
        for(Payment pay : Payment.values()){
            p.add(StringUtils.toString(pay));    
        }
        List<Material> materials = material.getMaterials();
        List<Supplier> supplier = sup.getAllSupplier();
        model.addAttribute("materials", materials);
        model.addAttribute("supplier", supplier);
        model.addAttribute("paymentOpt",p);
        return "addorder";
    }
}
