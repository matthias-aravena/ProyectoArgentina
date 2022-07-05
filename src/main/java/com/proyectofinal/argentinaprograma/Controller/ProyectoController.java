/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Controller;

import com.proyectofinal.argentinaprograma.Entity.Proyecto;
import com.proyectofinal.argentinaprograma.Service.ProyectoService;
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
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;
    
    //listar
    @GetMapping("/proyectos")
    public List<Proyecto> listar(){
        return proyectoService.findAll();
    }
    //guardar
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyectos")
    public Proyecto guardar(@RequestBody Proyecto proyecto){
        return proyectoService.save(proyecto);
    }
    @GetMapping("/proyectos/{id}")
    public Proyecto getProyecto(@PathVariable Long id){
        return proyectoService.findById(id);
    }
    
    //actualizar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyectos/{id}")
    public Proyecto actualizar(@RequestBody Proyecto proyecto, @PathVariable Long id ){
        Proyecto proyectoActual= proyectoService.findById(id);
        proyectoActual.setImagenProyecto(proyecto.getImagenProyecto());
        proyectoActual.setTituloProyecto(proyecto.getTituloProyecto());
        proyectoActual.setDescProyecto(proyecto.getDescProyecto());
        return proyectoService.save(proyectoActual);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyectos/{id}")
    public void eliminar(@PathVariable Long id){
      proyectoService.delete(id);
    }
}
