/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.service;

import com.XPTB.DTO.UserDTO;
import com.XPTB.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ADMIN
 */
public interface UserService extends UserDetailsService {

//    User addUser(User user);
    User getUserByUsername(String username);
    boolean authUser(String username, String password);
    List<UserDTO> getAllUser(Map<String,String> params);
    public void save (User u);
    User getUserById(int id);
    public void edit (User u);
    public void delete(int id);
}
