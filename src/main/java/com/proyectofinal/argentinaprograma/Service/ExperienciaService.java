/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Service;

import com.proyectofinal.argentinaprograma.Entity.Experiencia;
import java.util.List;


public interface ExperienciaService {
    public List<Experiencia> findAll();
    public Experiencia save(Experiencia experiencia);
    public Experiencia findById(Long id);
    public void delete(Long id);
}
