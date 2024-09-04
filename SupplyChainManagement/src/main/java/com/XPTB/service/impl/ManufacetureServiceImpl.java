/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.service.impl;

import com.XPTB.DTO.ManufactureDTO;
import com.XPTB.pojo.Manufacture;
import com.XPTB.repository.ManufactureRepository;
import com.XPTB.service.ManufacetureService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ManufacetureServiceImpl implements ManufacetureService{
    @Autowired
    private ManufactureRepository Manurepo;

    @Override
    public List<ManufactureDTO> getAllManufacture(Map<String, String> params) {
        List<Manufacture> manu = this.Manurepo.getAllManufacture(params);
        List<ManufactureDTO> manuDTO = new ArrayList<>();
        for(Manufacture m : manu){
            manuDTO.add(new ManufactureDTO(m));
        }
        return manuDTO;
    }

    @Override
    public ManufactureDTO getManufactureById(int id) {
        ManufactureDTO manu = new ManufactureDTO(this.Manurepo.getManufactureById(id));
        return manu;
    }

    @Override
    public void save(Manufacture manu) {
        this.Manurepo.save(manu);
    }

    @Override
    public void delete(int id) {
        this.Manurepo.delete(id);
    }

    @Override
    public List<Manufacture> getManufacture(Map<String, String> map) {
        return this.Manurepo.getAllManufacture(map);
    }

    @Override
    public Manufacture getManufactureId(int i) {
        return this.Manurepo.getManufactureById(i);
    }

    @Override
    public List<Manufacture> getManufacture() {
        return this.Manurepo.getAllManufacture();
    }
    
}
