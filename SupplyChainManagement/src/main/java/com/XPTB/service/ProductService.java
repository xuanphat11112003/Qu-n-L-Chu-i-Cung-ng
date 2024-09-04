/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ProductService {
    List<Product> getListProducts(Map<String, String> params);
    void addOrUpdate(Product p);
    void deleteProduct(int id);
    Product getProductById ( int id);
    List<Product> getListProducts();
}
