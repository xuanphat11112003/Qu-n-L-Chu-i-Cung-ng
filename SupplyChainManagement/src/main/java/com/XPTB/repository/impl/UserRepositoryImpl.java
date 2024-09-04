/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.User;
import com.XPTB.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private BCryptPasswordEncoder passEncoder;

//    @Override
//    public User addUser(User user) {
//        User u = new User(1);
//        return u;
//    }
    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);
        return (User) q.getSingleResult();
    }
    @Override
    public boolean authUser(String username, String password) {
        User  u = this.getUserByUsername(username);
        
        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public List<User> getAllUser(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> cq = b.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        List<Predicate> predicates = new ArrayList<>();
        String name = params.get("name");
        if(name != null && !name.isEmpty()){
            Predicate p1 = b.like(root.get("name").as(String.class), String.format("%%%s%%", name));
            predicates.add(p1);
        }
        String role = params.get("role");
        if(role != null){
            predicates.add(b.equal(root.get("userRole"), role));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        Query query = s.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void save(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        if(u.getId() != null)
            s.update(u);
        else
            s.save(u);
    }

    @Override
    public User getnUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class,id);
    }

    @Override
    public void delete(int i) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getnUserById(i));
    }

}
