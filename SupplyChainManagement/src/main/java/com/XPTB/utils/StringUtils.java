/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.utils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import lombok.Getter;
/**
 *
 * @author ADMIN
 */

public class StringUtils {
      private static SimpleDateFormat DateFormating = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);;

    /**
     * @return the DateFormating
     */
    public static SimpleDateFormat getDateFormating() {
        return DateFormating;
    }
}
