/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Controller;

import com.proyectofinal.argentinaprograma.Entity.Skill;
import com.proyectofinal.argentinaprograma.Service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    
    //listar
    @GetMapping("/skills")
    public List<Skill> listar(){
        return skillService.findAll();
    }
    //guardar
    @PostMapping("/skills")
    public Skill guardar(@RequestBody Skill skill){
        return skillService.save(skill);
    }
    @GetMapping("/skills/{id}")
    public Skill getExperiencia(@PathVariable Long id){
        return skillService.findById(id);
    }
    
    //actualizar
    @PutMapping("/skills/{id}")
    public Skill actualizar(@RequestBody Skill skill, @PathVariable Long id ){
        Skill skillActual= skillService.findById(id);
        skillActual.setNombreSkill(skill.getNombreSkill());
        skillActual.setImagenSkill(skill.getImagenSkill());
        skillActual.setPorcentajeSkill(skill.getPorcentajeSkill());
        return skillService.save(skillActual);
    }
    @DeleteMapping("/experiencias/{id}")
    public void eliminar(@PathVariable Long id){
      skillService.delete(id);  
    }
}
