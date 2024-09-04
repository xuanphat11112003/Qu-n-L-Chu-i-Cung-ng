/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface UserRepository {
//    User addUser(User user);

    User getUserByUsername(String username);

    boolean authUser(String username, String password);
    
    List<User> getAllUser(Map<String,String> params);
    
    public void save(User u);
    
    User getnUserById (int id);
    
    public void delete(int id);
}
