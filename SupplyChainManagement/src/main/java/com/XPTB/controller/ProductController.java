/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Product;
import com.XPTB.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService product;
    
    @RequestMapping("/product")
    public String product(Model model) {
        model.addAttribute("product", this.product.getListProducts());
        return "product";
    }
    @GetMapping("/add-product")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "add-product";
    }
    @PostMapping("/add-product")
    public String createView(Model model, 
            @ModelAttribute(value = "product") @Valid Product p,
            BindingResult rs) {
            if (rs.hasErrors())
            return "add-product";
        try {
            this.product.addOrUpdate(p);  
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        return "add-product";
    }

}