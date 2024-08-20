/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.Importorder;


/**
 *
 * @author ADMIN
 */
public interface ImportOderRepository {
    public void save(Importorder impoder);
    public void UpdateActive(int id);
    public Importorder getImportorderById(int id);
}
