/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Security.jwt;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.AuthenticationEntryPoint;


import org.springframework.stereotype.Component;

@Component 
public class jwtEntryPoint implements AuthenticationEntryPoint{
    
    private final static Logger logger = LoggerFactory.getLogger(jwtEntryPoint.class);
    
    
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e)
            throws IOException, ServletException {
        logger.error("error en el metodo commence" + e.getMessage());
        String s = "no autorizado";
        res.resetBuffer();
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, s);
        res.setHeader("Content-Type", "application/json");
        res.getOutputStream().print("{\"status\":401, \"error\":\"Unauthorized\",\"message\": \"No esta autorizado\"}");
        res.flushBuffer();
    }
    
    
}
