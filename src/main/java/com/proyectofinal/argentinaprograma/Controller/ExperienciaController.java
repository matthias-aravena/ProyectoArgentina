/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Controller;

import com.proyectofinal.argentinaprograma.Entity.Experiencia;
import com.proyectofinal.argentinaprograma.Service.ExperienciaService;
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
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/experiencia")
public class ExperienciaController {
    @Autowired
    private ExperienciaService experienciaService;
    
    //listar
    @GetMapping("/experiencias")
    public List<Experiencia> listar(){
        return experienciaService.findAll();
    }
    //guardar
   
    @PostMapping("/experiencias")
    public Experiencia guardar(@RequestBody Experiencia experiencia){
        return experienciaService.save(experiencia);
    }
    @GetMapping("/experiencias/{id}")
    public Experiencia getExperiencia(@PathVariable Long id){
        return experienciaService.findById(id);
    }
    
    //actualizar
    
    @PutMapping("/experiencias/{id}")
    public Experiencia actualizar(@RequestBody Experiencia experiencia, @PathVariable Long id ){
        Experiencia experienciaActual= experienciaService.findById(id);
        experienciaActual.setNombreTrabajo(experiencia.getNombreTrabajo());
        experienciaActual.setDescTrabajo(experiencia.getDescTrabajo());
        return experienciaService.save(experienciaActual);
    }
    
    @DeleteMapping("/experiencias/{id}")
    public void eliminar(@PathVariable Long id){
      experienciaService.delete(id);  
    }
    
}
