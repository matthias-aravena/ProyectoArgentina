/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Controller;


import com.proyectofinal.argentinaprograma.Entity.Educacion;
import com.proyectofinal.argentinaprograma.Service.EducacionService;
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
@RequestMapping("/educacion")
public class EducacionController {
    @Autowired
    private EducacionService educacionService;

//listar
    @GetMapping("/educaciones")
    public List<Educacion> listar(){
        return educacionService.findAll();
    }
    //guardar
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/educaciones")
    public Educacion guardar(@RequestBody Educacion educacion){
        return educacionService.save(educacion);
    }
    @GetMapping("/educaciones/{id}")
    public Educacion getEducacion(@PathVariable Long id){
        return educacionService.findById(id);
    }
    
    //actualizar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/educaciones/{id}")
    public Educacion actualizar(@RequestBody Educacion educacion, @PathVariable Long id ){
        Educacion educacionActual= educacionService.findById(id);
        educacionActual.setNombreEducacion(educacion.getNombreEducacion());
        educacionActual.setDescEducacion(educacion.getDescEducacion());
        return educacionService.save(educacionActual);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educaciones/{id}")
    public void eliminar(@PathVariable Long id){
      educacionService.delete(id);  
    }
}
