/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.pojo.Detailimportorder;

import java.util.List;
import com.XPTB.pojo.Importorder;

/**
 *
 * @author ADMIN
 */
public interface ImportOderService {
    public void save(Importorder impoder, List<Detailimportorder> detail);
}
