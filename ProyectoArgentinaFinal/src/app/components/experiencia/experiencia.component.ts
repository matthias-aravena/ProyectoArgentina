import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/Model/experiencia.model';
import { experienciaService } from 'src/app/service/experiencia.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  lista:any=[];
  nuevaExperiencia: Experiencia={id:'', nombreTrabajo:'', descTrabajo:''};
  
 
  constructor(private ExperienciaService: experienciaService) { }

  ngOnInit(): void {
    this.listarExperiencia();
   
    }

  listarExperiencia(){
    this.ExperienciaService.getExperiencias().subscribe(
      res=>{this.lista=res}
    );
  }
  agregarExperiencia(){
    this.ExperienciaService.guardarExperiencia(this.nuevaExperiencia).subscribe(res=>{
      this.listarExperiencia();
    });
  }
  eliminarExperiencia(id: string){
    this.ExperienciaService.deleteExperiencia(id).subscribe(
      res=>{this.listarExperiencia();}
    );
  }
  
 
  }
      
    
  


