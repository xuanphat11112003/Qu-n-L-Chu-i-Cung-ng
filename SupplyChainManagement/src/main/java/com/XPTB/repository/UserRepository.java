/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.XPTB.repository;

import com.XPTB.pojo.User;

/**
 *
 * @author ADMIN
 */
public interface UserRepository {
//    User addUser(User user);

    User getUserByUsername(String username);

    boolean authUser(String username, String password);
}
