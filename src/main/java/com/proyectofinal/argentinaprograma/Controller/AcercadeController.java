/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Controller;

import com.proyectofinal.argentinaprograma.Entity.Acercade;
import com.proyectofinal.argentinaprograma.Service.AcercadeService;
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
@RequestMapping("/acercade")
public class AcercadeController {
    @Autowired
    private AcercadeService acercadeService;
    
    //listar
    @GetMapping("/acerca")
    public List<Acercade> listar(){
        return acercadeService.findAll();
    }
    //guardar
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/acerca")
    public Acercade guardar(@RequestBody Acercade acercade){
        return acercadeService.save(acercade);
        
    }
    
    @GetMapping("/acerca/{id}")
    public Acercade getAcercade(@PathVariable Long id){
        return acercadeService.findById(id);
    }
    
    //actualizar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/acerca/{id}")
    public Acercade actualizar(@PathVariable Long id, @RequestBody Acercade acercade){
        Acercade acercadeActual= acercadeService.findById(id);
        acercadeActual.setNombre(acercade.getNombre());
        acercadeActual.setTitulo(acercade.getTitulo());
        acercadeActual.setSobreMi(acercade.getSobreMi());
        return acercadeService.save(acercadeActual);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/acerca/{id}")
    public void eliminar(@PathVariable Long id){
      acercadeService.delete(id);  
    }
}
