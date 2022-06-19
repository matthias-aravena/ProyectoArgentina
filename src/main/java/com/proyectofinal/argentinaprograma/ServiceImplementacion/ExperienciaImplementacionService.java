/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.ServiceImplementacion;

import com.proyectofinal.argentinaprograma.Entity.Experiencia;
import com.proyectofinal.argentinaprograma.Service.ExperienciaService;
import com.proyectofinal.argentinaprograma.Repository.RepoExperiencia;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExperienciaImplementacionService implements ExperienciaService {
    @Autowired
    private RepoExperiencia repoExperiencia;
    @Override
    @Transactional(readOnly=true)
    public List<Experiencia> findAll(){
        return (List<Experiencia>) repoExperiencia.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Experiencia save(Experiencia experiencia){
        return repoExperiencia.save(experiencia);
    }
    @Override
    @Transactional(readOnly=true)
    public Experiencia findById(Long id){
        return repoExperiencia.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Long id){
        repoExperiencia.deleteById(id);
    }
}
