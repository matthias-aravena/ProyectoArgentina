/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Controller;

import com.proyectofinal.argentinaprograma.Entity.Persona;
import com.proyectofinal.argentinaprograma.Service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/persona")
public class PersonaController {
    @Autowired 
    IPersonaService ipersonaService;
    
    //listar
    @GetMapping("/personas")
    public List<Persona> getBanner(){
        return ipersonaService.getPersona();
    }
    //guardar
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas")
    public void guardar(@RequestBody Persona persona){
        ipersonaService.save(persona);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/{id}")
    public void eliminar(@PathVariable Long id){
      ipersonaService.delete(id);  
    }
    //actualizar
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/{id}")
    public void updatePersona(@PathVariable Long id, @RequestBody Persona persona){
        
        Persona personaActual= ipersonaService.findById(id);
        personaActual.setNombre(persona.getNombre());
        personaActual.setApellido(persona.getApellido());
        personaActual.setImg(persona.getImg());
        ipersonaService.save(personaActual);
    }
    @GetMapping("/banners/{id}")
    public Persona getBanner(@PathVariable Long id){
        return ipersonaService.findById(id);
    }
    
}
