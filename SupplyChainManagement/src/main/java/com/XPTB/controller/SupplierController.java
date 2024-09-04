/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Supplier;
import com.XPTB.pojo.Supplierperformance;
import com.XPTB.service.SupplierPerformanceService;
import com.XPTB.service.SupplierService;
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
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SupplierPerformanceService supplierPerformanceService;
    
    @RequestMapping("/index")
    public String indexSupplier(Model model,@RequestParam Map<String, String> params){
        model.addAttribute("supllier", this.supplierService.getAllSupplier(params));
        return "ïndexsupplier"; 
    }
    @GetMapping("/add")
    public String SeeAddSupplier(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "addsupplier";
    }

    @PostMapping("/add")
    public String AddSupplier(Model model,
            @ModelAttribute(value = "supplier") @Valid Supplier p,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "addsupplier";
        }
        try {
            this.supplierService.AddorUpdate(p);
            return"redirect:/warehouse/index";
        } catch (Exception e) {
            model.addAttribute("errMsg", e.getMessage());
        }
        return "addsupplier";
    }
    @GetMapping("/add/{Id}")
    public String detailsView(Model model, @PathVariable(value = "Id") int id) {
        model.addAttribute("supplier", this.supplierService.getSupplierByid(id));
        return "addsupplier";
    }
    @GetMapping("/evaluate/add/{oderid}/{supplierid}")
    public String SeeAddEvaluateSupplier(Model model,
            @PathVariable(value = "oderid") int oid,
            @PathVariable(value = "supplierid") int sid) {
        model.addAttribute("supplier", new Supplierperformance());
        model.addAttribute("oid", oid);
        model.addAttribute("sid", sid);
        model.addAttribute("sup", this.supplierService.getSupplierByid(sid));
        return "addEvaluatesupplier";
    }
    //này xem tổng quát tất cả mà chưa có giao diện mới có giao diện xem chi tiết thôi
    @GetMapping("/evaluate")
    public String SeeEvaluate(Model model,@RequestParam Map<String,String> params){
        model.addAttribute("supFor",this.supplierPerformanceService.performanceSupplierDTOs(params));
        return "indexevaluate";
    }
    
   
    
}
