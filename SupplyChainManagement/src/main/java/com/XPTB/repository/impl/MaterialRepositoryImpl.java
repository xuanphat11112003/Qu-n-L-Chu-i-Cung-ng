package com.XPTB.repository.impl;


import com.XPTB.pojo.Material;
import com.XPTB.repository.MaterialRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class MaterialRepositoryImpl implements MaterialRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Material> getMaterials() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Material.findAll");
        return q.getResultList();
    }

<<<<<<< HEAD
    @Override
    public Material getMaterialById(int id) {
        Session  s = this.factory.getObject().getCurrentSession();
        return s.get(Material.class,id);
    }

=======
>>>>>>> 73f473402519512d283afc13ec32a081b94a2390
}
