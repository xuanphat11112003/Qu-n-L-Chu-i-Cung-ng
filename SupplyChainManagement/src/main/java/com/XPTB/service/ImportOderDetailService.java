/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.pojo.Detailimportorder;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ImportOderDetailService {
    public void save(Detailimportorder d);
    public List<Object[]> getDetailOrder(Map<String,String> params);
    
}
