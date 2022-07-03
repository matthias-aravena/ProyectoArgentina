/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Service;

import com.proyectofinal.argentinaprograma.Entity.Skill;
import java.util.List;


public interface SkillService {
    public List<Skill> findAll();
    public Skill save(Skill skill);
    public Skill findById(Long id);
    public void delete(Long id);
}
