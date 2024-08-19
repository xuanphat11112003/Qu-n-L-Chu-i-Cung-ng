/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Detailimportorder;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ImportOderDetailsRepository {
    public void saveimp(Detailimportorder di);
    public List<Object[]> getDetailOrder(Map<String,String> params);
    
}
