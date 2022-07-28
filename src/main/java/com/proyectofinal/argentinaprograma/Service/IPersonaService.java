/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Service;

import com.proyectofinal.argentinaprograma.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    public List<Persona> getPersona();
    
    public void save(Persona persona);
    
    public void delete(Long id);
    
    public void updatePersona(Persona persona);
    
    public Persona findById(Long id);
    
    }
