/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.ServiceImplementacion;

import com.proyectofinal.argentinaprograma.Entity.Educacion;
import com.proyectofinal.argentinaprograma.Repository.RepoEducacion;
import com.proyectofinal.argentinaprograma.Service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EducacionImplementacionService implements EducacionService{
    @Autowired
    private RepoEducacion repoEducacion;
    @Override
    @Transactional(readOnly=true)
    public List<Educacion> findAll(){
        return (List<Educacion>) repoEducacion.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Educacion save(Educacion educacion){
        return repoEducacion.save(educacion);
    }
    @Override
    @Transactional(readOnly=true)
    public Educacion findById(Long id){
        return repoEducacion.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Long id){
        repoEducacion.deleteById(id);
    }
    
}
