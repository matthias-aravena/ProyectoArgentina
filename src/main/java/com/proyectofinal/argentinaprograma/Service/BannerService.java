/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.argentinaprograma.Service;

import com.proyectofinal.argentinaprograma.Entity.Banner;
import java.util.List;



public interface BannerService {
    
    public List<Banner> getBanner();
    
    public void save(Banner banner);
    
    public void delete(Long id);
    
    public void updateBanner(Banner banner);
    
    public Banner findById(Long id);
    
    
}
