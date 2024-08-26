/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.DTO.PerformanceSupplierDTO;
import com.XPTB.pojo.Importorder;
import com.XPTB.pojo.Supplierperformance;
import com.XPTB.repository.SupplierPerformaceRepository;
import com.XPTB.service.ImportOderService;
import com.XPTB.service.SupplierPerformanceService;
import com.XPTB.service.SupplierService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class SupplierPerformanceServiceImpl implements SupplierPerformanceService {

    @Autowired
    private SupplierPerformaceRepository e;
    @Autowired
    private SupplierService s;
    @Autowired
    private ImportOderService o;

    @Override
    public void save(PerformanceSupplierDTO performanceSupplierDTO) {
        Supplierperformance supPerfor = new Supplierperformance();
        Date currentDate = new Date();
        supPerfor.setEvaluationDate(currentDate);
        supPerfor.setDeliveryRating(performanceSupplierDTO.getDeliveryRating());
        supPerfor.setPriceRating(performanceSupplierDTO.getPriceRating());
        supPerfor.setQualityRating(performanceSupplierDTO.getQualityRating());
        supPerfor.setComment(performanceSupplierDTO.getComment());
        supPerfor.setSupplier(this.s.getSupplierByid(performanceSupplierDTO.getSupplier()));
        Importorder imp1 =this.o.getImportorderById(performanceSupplierDTO.getImportorder());
        supPerfor.setOrderId(imp1);
        imp1.setActiveEvaluate(true);
        this.o.save(imp1);
        this.e.save(supPerfor);
    }

    @Override
    public List<PerformanceSupplierDTO> performanceSupplierDTOs(Map<String, String> params) {
        List<Supplierperformance> supPerfor = this.e.getAllRate(params);
        List<PerformanceSupplierDTO> dto = new ArrayList<>();
        
        for(Supplierperformance s : supPerfor){
            dto.add(new PerformanceSupplierDTO(s));
        }
        return dto;
    }

    @Override
    public List<Object[]> Stats(Map<String, String> params) {
        return this.e.Stats(params);
    }

    @Override
    public List<Object[]> StatsByM(Map<String, String> map) {
        return this.e.StatsByM(map);
    }


}
