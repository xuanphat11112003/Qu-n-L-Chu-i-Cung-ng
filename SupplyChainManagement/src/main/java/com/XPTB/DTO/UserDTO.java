/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.DTO;

import com.XPTB.pojo.User;
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
public class UserDTO {
    private int id;
    private String username;
    private String user_role;
    private String email;
    private String name;
    private String address;
    private String phone;
    private String avatar;
    public UserDTO(User u ){
        this.id = u.getId();
        this.username = u.getUsername();
        this.user_role = u.getUserRole();
        this.address = u.getAdress();
        this.phone = u.getPhone();
        this.avatar = u.getAvartar();
        this.email = u.getEmail();
        this.name = u.getName();
    }
    
}
