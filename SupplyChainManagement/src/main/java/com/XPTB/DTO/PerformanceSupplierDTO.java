/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.DTO;

import com.XPTB.pojo.Importorder;
import com.XPTB.pojo.Supplier;
import com.XPTB.pojo.Supplierperformance;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Getter
@Setter
@NoArgsConstructor
public class PerformanceSupplierDTO {
    private int deliveryRating;
    private int qualityRating;
    private int priceRating;
    private String comment;
    private int supplier;
    private int importorder;
    private String nameSupplier;
    private Date evaluationDate;
    public PerformanceSupplierDTO(Supplierperformance supFor){
        this.comment = supFor.getComment();
        this.deliveryRating = supFor.getDeliveryRating();
        this.evaluationDate= supFor.getEvaluationDate();
        this.importorder=supFor.getOrderId().getId();
        this.priceRating = supFor.getPriceRating();
        this.qualityRating = supFor.getQualityRating();
        if(supFor.getSupplier() !=null){
            this.supplier = supFor.getSupplier().getId();
            this.nameSupplier=supFor.getSupplier().getName();
        }
    }
}
