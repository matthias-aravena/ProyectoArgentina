/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Security.jwt;


import com.proyectofinal.argentinaprograma.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class jwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(jwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal;
        usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername()).
                setIssuedAt(new Date()).
                setExpiration(new Date(new Date().getTime() + expiration * 1000)).signWith(SignatureAlgorithm.HS512, secret).
                compact();
    }
            
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).
                getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token Mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token Mal vacio");
        }catch (SignatureException e){
            logger.error("falla en la firma");
        }
    
        return false;
    
        }
}
