/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Security.jwt;

import com.proyectofinal.argentinaprograma.Security.Service.UserDetailServiceImpl;


import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;




import org.springframework.web.filter.OncePerRequestFilter;



public class jwtTokenFilter extends OncePerRequestFilter{
   
    private final static Logger logger = LoggerFactory.getLogger(jwtTokenFilter.class);
    
    @Autowired
    jwtProvider JwtProvider;
    
    @Autowired
    UserDetailServiceImpl userDetailService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
            FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(req);
            if(token != null && JwtProvider.validateToken(token)){
                String nombreUsuario = JwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (Exception e){
        logger.error("fallo el metodo dofilter");
        }
        filterChain.doFilter(req, res);
    }
    private String getToken(HttpServletRequest request){
        String S = "Authorization";
         String header = request.getHeader(S);
        if(header != null && header.startsWith("Bearer"))
         return header.replace("Bearer ", "");
         return null;
    }
}
