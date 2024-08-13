/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;


import com.XPTB.service.MaterialService;
import com.XPTB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class HomeController {


    


//    @Autowired
//    private MaterialService materialService;
//    @Autowired
//    private UserService userDetailsService;


   

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("material",this.materialService.getMaterials().get(0));
//        System.out.println(this.materialService.getMaterials().get(1).getName());
//        model.addAttribute("user", this.userDetailsService.getUserByUsername("admin"));
//        System.out.println(this.userDetailsService.getUserByUsername("admin").getName());
        return "index";
    }
}
