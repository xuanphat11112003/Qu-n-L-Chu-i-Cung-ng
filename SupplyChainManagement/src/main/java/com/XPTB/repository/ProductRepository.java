/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Product;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ProductRepository {
    List<Product> getListProducts();
    void addOrUpdate(Product p);
}
