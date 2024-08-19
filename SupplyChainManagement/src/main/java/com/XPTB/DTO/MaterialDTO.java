/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.DTO;

import com.XPTB.pojo.Material;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Getter
@Setter

public class MaterialDTO {
    private int id;
    private String name;
    private Long price;
    private int supplierId;
    private String supplierName;
    public MaterialDTO(){}
    public MaterialDTO(Material material){
        this.id = material.getId();
        this.name = material.getName();
        this.price = material.getPrice();
        if(material.getSupplierId()!=null){
            this.supplierId = material.getSupplierId().getId();
            this.supplierName = material.getSupplierId().getName();
        }
    }
    
    
}
