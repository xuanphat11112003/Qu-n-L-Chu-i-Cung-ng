/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.DTO;

import com.XPTB.pojo.Supplier;
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
public class SupplierDTO {
    private int id;
    private String name;
    private String address;
    private String phone;
    public SupplierDTO(Supplier sup){
        this.id = sup.getId();
        this.name = sup.getName();
        this.address = sup.getAddress();
        this.phone = sup.getPhone();
    }
}
