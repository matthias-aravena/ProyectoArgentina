/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.ServiceImplementacion;

import com.proyectofinal.argentinaprograma.Entity.Skill;
import com.proyectofinal.argentinaprograma.Repository.RepoSkill;
import com.proyectofinal.argentinaprograma.Service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkillImplementacionService implements SkillService{
    @Autowired
    private RepoSkill repoSkill;
    @Override
    @Transactional(readOnly=true)
    public List<Skill> findAll(){
        return (List<Skill>) repoSkill.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Skill save(Skill skill){
        return repoSkill.save(skill);
    }
    @Override
    @Transactional(readOnly=true)
    public Skill findById(Long id){
        return repoSkill.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Long id){
        repoSkill.deleteById(id);
    }
}
