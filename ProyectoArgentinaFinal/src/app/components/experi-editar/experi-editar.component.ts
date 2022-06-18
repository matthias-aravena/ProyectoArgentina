import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/Model/experiencia.model';
import { experienciaService } from 'src/app/service/experiencia.service';

@Component({
  selector: 'app-experi-editar',
  templateUrl: './experi-editar.component.html',
  styleUrls: ['./experi-editar.component.css']
})
export class ExperiEditarComponent implements OnInit {
  id: string ="";
  editExperiencia:  Experiencia={id:'',nombreTrabajo: '',descTrabajo:''};
  constructor(private ExperienciaService: experienciaService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {}

  ngOnInit(): void {
    this.id= this.activatedRoute.snapshot.params['id'];
    this.ExperienciaService.getunaExperiencia(this.id).subscribe(
      data=>{this.editExperiencia=data;}
    );
  }
  modificarExperiencia(){
    this.ExperienciaService.editarExperiencia(this.id, this.editExperiencia).subscribe(
      data=>{
      this.router.navigate(['/home']);}
     );
    
  }

}
