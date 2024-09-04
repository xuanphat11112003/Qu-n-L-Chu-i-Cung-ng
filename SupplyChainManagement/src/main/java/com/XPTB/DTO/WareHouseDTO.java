/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.DTO;

import com.XPTB.pojo.Warehouse;
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
public class WareHouseDTO {
    private int id;
    private String name;
    private String address;
    public WareHouseDTO(Warehouse w){
        this.id = w.getId();
        this.name = w.getName();
        this.address= w.getAddress();
    }
    
}
