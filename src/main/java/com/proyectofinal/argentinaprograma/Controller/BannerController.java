/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Controller;

import com.proyectofinal.argentinaprograma.Entity.Banner;
import com.proyectofinal.argentinaprograma.Service.BannerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    //listar
    @GetMapping("/banners")
    public List<Banner> getBanner(){
        return bannerService.getBanner();
    }
    //guardar
    
    @PostMapping("/banners")
    public void guardar(@RequestBody Banner banner){
        bannerService.save(banner);
    }
    
   
    @DeleteMapping("/banners/{id}")
    public void eliminar(@PathVariable Long id){
      bannerService.delete(id);  
    }
    //actualizar
    
    @PutMapping("banners/{id}")
    public void updateBanner(@PathVariable Long id, @RequestBody Banner banner){
        
        Banner bannerActual= bannerService.findById(id);
        bannerActual.setImagenBanner(banner.getImagenBanner());
        bannerService.save(bannerActual);
    }
    @GetMapping("/banners/{id}")
    public Banner getBanner(@PathVariable Long id){
        return bannerService.findById(id);
    }
    
}
