/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.pojo.Detailimportorder;
import com.XPTB.pojo.Importorder;
import com.XPTB.repository.ImportOderDetailsRepository;
import com.XPTB.repository.ImportOderRepository;
import com.XPTB.repository.MaterialRepository;
import com.XPTB.service.ImportOderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ImportOderServiceImpl implements ImportOderService{
    @Autowired
    private ImportOderRepository importOrderRepository;

    @Autowired
    private ImportOderDetailsRepository detailImportOrderRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public void save(Importorder impoder, List<Detailimportorder> detail) {
        importOrderRepository.save(impoder);
        for(Detailimportorder d : detail){
            detailImportOrderRepository.saveimp(d);
        } 
    }
    
}
