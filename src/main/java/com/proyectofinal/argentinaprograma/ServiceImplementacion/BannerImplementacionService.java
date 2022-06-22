/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.ServiceImplementacion;

import com.proyectofinal.argentinaprograma.Entity.Banner;
import com.proyectofinal.argentinaprograma.Repository.RepoBanner;
import com.proyectofinal.argentinaprograma.Service.BannerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BannerImplementacionService implements BannerService{
    @Autowired
    private RepoBanner repoBanner;
    @Override
    @Transactional(readOnly=true)
    public List<Banner> findAll(){
        return (List<Banner>) repoBanner.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Banner save(Banner banner){
        return repoBanner.save(banner);
    }
    @Override
    @Transactional(readOnly=true)
    public Banner findById(Long id){
        return repoBanner.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Long id){
        repoBanner.deleteById(id);
    }
}
