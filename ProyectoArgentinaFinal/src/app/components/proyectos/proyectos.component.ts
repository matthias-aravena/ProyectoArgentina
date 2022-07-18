import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/Model/proyecto.model';
import { proyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {
  proyecto : Proyecto = {id:'', imagenProyecto:'',tituloProyecto:''  , descProyecto:''};

  lista:any=[];
  nuevoProyecto: Proyecto={id:'', imagenProyecto:'',tituloProyecto:''  , descProyecto:''};
  imageProyecto = '';
  imgURL = 'assets/bocaescudo.jpg';
  constructor(private ProyectoService: proyectoService,
              private http: HttpClient  ) { }

  ngOnInit(): void {
    this.listarProyectos();
  }
  listarProyectos(){
    this.ProyectoService.getProyectos().subscribe(
      res=>{this.lista=res}
    );
  }
  agregarProyectos(){
    this.ProyectoService.guardarProyecto(this.nuevoProyecto).subscribe(res=>{
      this.listarProyectos();
    });
  }
  eliminarProyecto(id: string){
    this.ProyectoService.deleteProyecto(id).subscribe(
      res=>{this.listarProyectos();}
    );
  }

  selectImageProyecto(event: any){
    console.log(event);
   if(event.target.files.length > 0){
   const file = event.target.files[0];
   const reader = new FileReader();
   reader.readAsDataURL(file);
  reader.onload = (event: any) =>{
  this.imgURL = event.target.result;
   }
   this.imageProyecto= file;

   }
  }
  onSubmit(){

  }


}
