/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Material;
import com.XPTB.pojo.Product;
import com.XPTB.service.MaterialService;
import com.XPTB.service.SupplierService;
import java.util.List;
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
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService ma;
    @Autowired
    private SupplierService sup;

    @RequestMapping("/index")
    public String IndexMaterial(Model model,@RequestParam Map<String, String> params) {
        model.addAttribute("material", this.ma.getMaterials(params));
        return "indexmaterial";
    }

    @GetMapping("/add")
    public String SeeAddMaterial(Model model) {
        model.addAttribute("material", new Material());
        model.addAttribute("suppliers", this.sup.getAllSupplier());
        return "addmaterial";
    }

    @PostMapping("/add")
    public String AddMaterial(Model model,
            @ModelAttribute(value = "material") @Valid Material p,
            BindingResult rs) {
        if (rs.hasErrors()) {
            model.addAttribute("suppliers", this.sup.getAllSupplier());
            return "addmaterial";
        }
        try {
            this.ma.AddorUpdate(p);
            return"redirect:/material/index";
        } catch (Exception e) {
            model.addAttribute("errMsg", e.getMessage());
        }
        return "addmaterial";
    }
    @GetMapping("/add/{materialId}")
    public String detailsView(Model model, @PathVariable(value = "materialId") int id) {
        model.addAttribute("material", this.ma.getMaterialById(id));
        return "addmaterial";
    }

}
