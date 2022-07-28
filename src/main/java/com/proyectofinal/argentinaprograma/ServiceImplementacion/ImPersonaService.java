/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.ServiceImplementacion;

import com.proyectofinal.argentinaprograma.Entity.Persona;
import com.proyectofinal.argentinaprograma.Service.IPersonaService;
import com.proyectofinal.argentinaprograma.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImPersonaService implements IPersonaService{
   @Autowired 
   IPersonaRepository ipersonaRepository; 
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Long id){
        ipersonaRepository.deleteById(id);
    }
    @Override
    public void updatePersona(Persona persona){
         ipersonaRepository.save(persona);
    }
    @Override
    @Transactional(readOnly=true)
    public Persona findById(Long id){
        return ipersonaRepository.findById(id).orElse(null);
    }
     @Override
    @Transactional(readOnly=false)
    public void save(Persona persona){
        ipersonaRepository.save(persona);
    }
    @Override
    @Transactional(readOnly=true)
    public List<Persona> getPersona(){
        List<Persona> listaPer = ipersonaRepository.findAll();
        return listaPer;
    }
 }
