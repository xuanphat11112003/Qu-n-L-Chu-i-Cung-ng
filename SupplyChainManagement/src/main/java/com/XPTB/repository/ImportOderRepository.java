/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Importorder;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ImportOderRepository {
    public void save(Importorder impoder);
    public void Create(Map<String, Object> params);
    
}
