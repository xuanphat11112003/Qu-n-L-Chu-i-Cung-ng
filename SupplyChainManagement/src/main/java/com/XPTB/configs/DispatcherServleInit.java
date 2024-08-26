/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.configs;


import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author ADMIN
 */
public class DispatcherServleInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
       return new Class[]{
           HibernateConfigs.class,
           TilesConfigs.class,
           SpringSecurityConfig.class,
           JwtSecurityConfig.class
           
       };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
            WebApplicationContextConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
        super.registerDispatcherServlet(servletContext);
        
        // Create and register CharacterEncodingFilter
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", encodingFilter);
        filterRegistration.addMappingForUrlPatterns(null, true, "/*");
    }


}
