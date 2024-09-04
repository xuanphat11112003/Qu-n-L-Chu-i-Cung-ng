/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.DTO;

import com.XPTB.pojo.Manufacture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Setter
@Getter
@NoArgsConstructor
public class ManufactureDTO {
    private int id;
    private int amount;
    private int ProductId;
    private String ProductName;
    private int MaterialId;
    private String MaterialName;
    public ManufactureDTO(Manufacture manu){
        this.id = manu.getId();
        this.amount = manu.getAmount();
        if(manu.getProductId() != null){
            this.ProductId = manu.getProductId().getId();
            this.ProductName = manu.getProductId().getName();
        }
        if(manu.getMaterialId() != null){
            this.MaterialId = manu.getMaterialId().getId();
            this.MaterialName = manu.getMaterialId().getName();
        }
        
    }
}
