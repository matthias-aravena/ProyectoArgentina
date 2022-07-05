/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Security.Controller;

import com.proyectofinal.argentinaprograma.Dto.Mensaje;
import com.proyectofinal.argentinaprograma.Security.Entity.Rol;
import com.proyectofinal.argentinaprograma.Security.Entity.Usuario;
import com.proyectofinal.argentinaprograma.Security.Enumerado.RolNombre;
import com.proyectofinal.argentinaprograma.Security.Service.RolService;
import com.proyectofinal.argentinaprograma.Security.Service.UsuarioService;
import com.proyectofinal.argentinaprograma.Security.dto.JwtDto;
import com.proyectofinal.argentinaprograma.Security.dto.LoginUsuario;
import com.proyectofinal.argentinaprograma.Security.dto.NuevoUsuario;
import com.proyectofinal.argentinaprograma.Security.jwt.jwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UsuarioController {
    @Autowired
    PasswordEncoder passwordEncoder; 
    @Autowired
    AuthenticationManager authenticationManager;       
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired   
    jwtProvider JwtProvider;
    
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ya existe el nombre"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ya existe el Email"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
        nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getContraseña()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USUARIO).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario,
            BindingResult bindingResult){
       if( bindingResult.hasErrors())
           return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
       Authentication authentication =
               authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
        (loginUsuario.getNombreUsuario(), loginUsuario.getContraseña()));
       SecurityContextHolder.getContext().setAuthentication(authentication);
       String jwt = JwtProvider.generateToken(authentication);
       UserDetails userDetails = (UserDetails)authentication.getPrincipal();
       JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
       return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}   
