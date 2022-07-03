/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Service;

import com.proyectofinal.argentinaprograma.Entity.Proyecto;
import java.util.List;


public interface ProyectoService {
    public List<Proyecto> findAll();
    public Proyecto save(Proyecto proyecto);
    public Proyecto findById(Long id);
    public void delete(Long id);
}
