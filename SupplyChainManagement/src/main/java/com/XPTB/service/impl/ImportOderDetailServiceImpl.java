/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Detailimportorder;
import com.XPTB.repository.ImportOderDetailsRepository;
import com.XPTB.service.ImportOderDetailService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ImportOderDetailServiceImpl implements ImportOderDetailService{
    @Autowired
    private ImportOderDetailsRepository d;
    
    @Override
    public void save(Detailimportorder d) {
        this.d.saveimp(d);
    }

   
    
}
