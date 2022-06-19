/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Service;

import com.proyectofinal.argentinaprograma.Entity.Educacion;
import java.util.List;


public interface EducacionService {
    public List<Educacion> findAll();
    public Educacion save(Educacion educacion);
    public Educacion findById(Long id);
    public void delete(Long id);
}
