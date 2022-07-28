import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/Model/experiencia.model';
import { experienciaService } from 'src/app/service/experiencia.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  lista:any=[];
  nuevaExperiencia: Experiencia={id:'', nombreTrabajo:'', descTrabajo:''};

  roles: string[];
  isAdmin = false;
  constructor(private ExperienciaService: experienciaService,
              private tokenService: TokenService) { }

  ngOnInit(): void {
    this.listarExperiencia();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(rol => {
      if(rol === 'ROLE_ADMIN'){
        this.isAdmin = true;
      }
    });
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





