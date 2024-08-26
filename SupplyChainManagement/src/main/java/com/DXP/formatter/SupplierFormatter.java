/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DXP.formatter;

import com.XPTB.pojo.Supplier;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class SupplierFormatter implements Formatter<Supplier>{

    @Override
    public String print(Supplier t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Supplier parse(String string, Locale locale) throws ParseException {
        Supplier s = new Supplier();
        s.setId(Integer.parseInt(string));
        return s;
    }
    
}
