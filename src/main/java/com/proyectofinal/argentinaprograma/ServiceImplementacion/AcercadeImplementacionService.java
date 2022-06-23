/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.ServiceImplementacion;

import com.proyectofinal.argentinaprograma.Entity.Acercade;
import com.proyectofinal.argentinaprograma.Repository.RepoAcercade;
import com.proyectofinal.argentinaprograma.Service.AcercadeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcercadeImplementacionService implements AcercadeService{
    @Autowired
    private RepoAcercade repoAcercade;
    @Override
    @Transactional(readOnly=true)
    public List<Acercade> findAll(){
        return (List<Acercade>) repoAcercade.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Acercade save(Acercade acercade){
        return repoAcercade.save(acercade);
    }
    @Override
    @Transactional(readOnly=true)
    public Acercade findById(Long id){
        return repoAcercade.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Long id){
        repoAcercade.deleteById(id);
    }
}
