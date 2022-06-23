/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Service;

import com.proyectofinal.argentinaprograma.Entity.Acercade;
import java.util.List;


public interface AcercadeService {
    public List<Acercade> findAll();
    public Acercade save(Acercade acercade);
    public Acercade findById(Long id);
    public void delete(Long id);
}
