/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Detailimportorder;
import com.XPTB.pojo.Importorder;
import com.XPTB.pojo.Material;
import com.XPTB.service.ImportOderService;
import com.XPTB.service.MaterialService;
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
    private ImportOderService importOrder;

    @Autowired
    private MaterialService materialRepository;

    @GetMapping("")
    public String showCreateOrderForm(Model model) {
        List<Material> materials = materialRepository.getMaterials();

        model.addAttribute("materials", materials);
        model.addAttribute("importOrder", new Importorder());
        model.addAttribute("details", new ArrayList<Detailimportorder>());
        return "order";
    }
}
