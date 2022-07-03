/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.ServiceImplementacion;

import com.proyectofinal.argentinaprograma.Entity.Proyecto;
import com.proyectofinal.argentinaprograma.Repository.RepoProyecto;
import com.proyectofinal.argentinaprograma.Service.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProyectoImplementacionService implements ProyectoService{
    @Autowired
    private RepoProyecto repoProyecto;
    @Override
    @Transactional(readOnly=true)
    public List<Proyecto> findAll(){
        return (List<Proyecto>) repoProyecto.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Proyecto save(Proyecto proyecto){
        return repoProyecto.save(proyecto);
    }
    @Override
    @Transactional(readOnly=true)
    public Proyecto findById(Long id){
        return repoProyecto.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Long id){
        repoProyecto.deleteById(id);
    }
}
