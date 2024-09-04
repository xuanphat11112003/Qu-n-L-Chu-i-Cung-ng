/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.controller;

import com.XPTB.pojo.Supplier;
import com.XPTB.pojo.User;
import com.XPTB.service.UserService;
import java.util.Map;
import javax.swing.text.html.parser.DTDConstants;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService User;
    
    @RequestMapping("/index")
    public String indexUser(@RequestParam Map<String, String> params,Model model){
        model.addAttribute("user", this.User.getAllUser(params));
        return "indexUser";
    }
    @RequestMapping("/add")
    public String seeAddUser(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }
    @PostMapping("/add")
    public String addUser (Model model,
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult rs){
        if (rs.hasErrors()) {
            return "addUser";
        }
        try {
            this.User.save(user);
            return "redirect:/user/index";
        } catch (Exception e) {
             model.addAttribute("errMsg", e.getMessage());
        }
        return "addUser";
    }
    @RequestMapping("add/{id}")
    public String updateUser(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("user", this.User.getUserById(id));
        return "addUser";
    }
    @RequestMapping("/edit")
    public String editUser(Model model, @RequestParam Map<String,String> params){
        String kw = params.get("id");
        int id = Integer.parseInt(kw);
        model.addAttribute("user", this.User.getUserById(id));
        return "addUser";
    }
    @PostMapping("/edit")
    public String editUser (Model model,
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult rs){
        if (rs.hasErrors()) {
            return "addUser";
        }
        try {
            this.User.edit(user);
            return "redirect:/user/index";
        } catch (Exception e) {
             model.addAttribute("errMsg", e.getMessage());
        }
        return "addUser";
    }
    
}
