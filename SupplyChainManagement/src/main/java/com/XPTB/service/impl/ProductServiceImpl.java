/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Product;
import com.XPTB.repository.ProductRepository;
import com.XPTB.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getListProducts() {
        return this.productRepo.getListProducts();
    }
    @Override
    public void addOrUpdate(Product p) {
//        if (!p.getFile().isEmpty()) {
//            try {
//                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(),
//                            ObjectUtils.asMap("resource_type", "auto"));
//                
//                p.setImage(res.get("secure_url").toString());
//            } catch (IOException ex) {
//                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        this.productRepo.addOrUpdate(p);
    }
    
}
