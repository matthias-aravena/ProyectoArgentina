import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/Model/proyecto.model';
import { proyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-proyedit',
  templateUrl: './proyedit.component.html',
  styleUrls: ['./proyedit.component.css']
})
export class ProyeditComponent implements OnInit {
  id: string ="";
  editProyecto : Proyecto={id:'',tituloProyecto:'',descProyecto:''};
  constructor(private ProyectoService: proyectoService,
              private activatedRoute: ActivatedRoute,
              private router: Router ) { }

  ngOnInit(): void {
    this.id= this.activatedRoute.snapshot.params['id'];
    this.ProyectoService.getunProyecto(this.id).subscribe(
      data=>{this.editProyecto=data;}
    );
  }
  modificarProyecto(){
    this.ProyectoService.editarProyecto(this.id, this.editProyecto).subscribe(
      data=>{
      this.router.navigate(['/home']);}
     );
    }

  }
