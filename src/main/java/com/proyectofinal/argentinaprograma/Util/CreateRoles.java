/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Util;

import com.proyectofinal.argentinaprograma.Security.Entity.Rol;
import com.proyectofinal.argentinaprograma.Security.Enumerado.RolNombre;
import com.proyectofinal.argentinaprograma.Security.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner{
    @Autowired
    RolService rolService;
    
    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUsuario = new Rol(RolNombre.ROLE_USUARIO);
        rolService.save(rolAdmin);
        rolService.save(rolUsuario);
    }
    
}
