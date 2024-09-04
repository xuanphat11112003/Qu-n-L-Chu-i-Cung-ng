/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.DTO.UserDTO;
import com.XPTB.pojo.User;
import com.XPTB.repository.UserRepository;
import com.XPTB.service.UserService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BCryptPasswordEncoder passEncoder;
    @Autowired
    private Cloudinary cloudinary;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Override
//    public User addUser(User user) {
//        return this.userRepo.addUser(user);
//    }
    @Override
    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid User!");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }
    @Override
    public boolean authUser(String username, String password) {
        return this.userRepo.authUser(username, password);
    }

    @Override
    public List<UserDTO> getAllUser(Map<String, String> params) {
        List<User> user = this.userRepo.getAllUser(params);
        List<UserDTO> u = new ArrayList<>();
        for(User usr : user){
            u.add(new UserDTO(usr));
        }
        return u;
    }

    @Override
    public void save(User u) {
        if (!u.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(u.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                
                u.setAvartar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(u.getId() == null){
            Date currentDate = new Date();
            u.setCreateDate(currentDate);
            u.setPassword(passEncoder.encode(u.getPassword()));
        }
        
        this.userRepo.save(u);
    }

    @Override
    public User getUserById(int i) {
        return this.userRepo.getnUserById(i);
    }

    @Override
    public void edit(User u) {
         if (!u.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(u.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                
                u.setAvartar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        u.setPassword(passEncoder.encode(u.getPassword()));
        
        
        this.userRepo.save(u);
    }

    @Override
    public void delete(int i) {
        this.userRepo.delete(i);
    }

}
