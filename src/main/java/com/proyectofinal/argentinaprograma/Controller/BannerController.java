/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Controller;

import com.proyectofinal.argentinaprograma.Entity.Banner;
import com.proyectofinal.argentinaprograma.Service.BannerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Banner> listar(){
        return bannerService.findAll();
    }
    //guardar
    @PostMapping("/banners")
    public Banner guardar(@RequestBody Banner banner){
        return bannerService.save(banner);
    }
    @GetMapping("/banners/{id}")
    public Banner getBanner(@PathVariable Long id){
        return bannerService.findById(id);
    }
    
    //actualizar
    @PutMapping("banners/{id}")
    public Banner actualizar(@RequestBody Banner banner, @PathVariable Long id ){
        Banner bannerActual= bannerService.findById(id);
        bannerActual.setImagenBanner(banner.getImagenBanner());
        return bannerService.save(bannerActual);
    }
    @DeleteMapping("/banners/{id}")
    public void eliminar(@PathVariable Long id){
      bannerService.delete(id);  
    }
}
