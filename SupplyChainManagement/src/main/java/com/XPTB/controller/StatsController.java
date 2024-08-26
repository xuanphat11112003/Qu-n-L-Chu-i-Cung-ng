/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.service.SupplierPerformanceService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    private SupplierPerformanceService superFor;
    
    @RequestMapping("/index")
    public String indexStats(Model model, Map<String, String> params){
        
        
        model.addAttribute("superFor",this.superFor.Stats(params));
        return ("indexstats");
    }
    @RequestMapping("/detail")
    public String detailStats(Model model,@RequestParam Map<String, String> params){
        model.addAttribute("superFor",this.superFor.Stats(params));
        model.addAttribute("superFor1",this.superFor.StatsByM(params));
        return ("detailstats");
    }
    
}
