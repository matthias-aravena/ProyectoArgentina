import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/Model/proyecto.model';
import { proyectoService } from 'src/app/service/proyecto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {



  lista:any=[];
  nuevoProyecto: Proyecto={id:'',tituloProyecto:''  , descProyecto:''};

  roles: string[];
  isAdmin = false;
  constructor(private ProyectoService: proyectoService,
              private http: HttpClient,
              private router: Router,
              private tokenService: TokenService ) { }

  ngOnInit(): void {
    this.listarProyectos();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(rol => {
      if(rol === 'ROLE_ADMIN'){
        this.isAdmin = true;
      }
    });
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


 // selectImageProyecto(event: any){
  //console.log(event);
   //if(event.target.files.length > 0){
   //const file = event.target.files[0];
   //const reader = new FileReader();
   //reader.readAsDataURL(file);
  //reader.onload = (event: any) =>{
  //this.imgURL = event.target.result;
   //}
   //this.imageProyecto= file;

   //}
  //}
  //onSubmit(){

  //}


}
