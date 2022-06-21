import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/Model/educacion.model';
import { educacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  lista:any=[];
  nuevaEducacion: Educacion={id:'', nombreEducacion:'', descEducacion:''};
  
  constructor(private EducacionService: educacionService) { }

  ngOnInit(): void {
    this.listarEducacion();
   
  }
  listarEducacion(){
    this.EducacionService.getEducaciones().subscribe(
      res=>{this.lista=res}
    );
  }
  agregarEducacion(){
    this.EducacionService.guardarEducacion(this.nuevaEducacion).subscribe(res=>{
      this.listarEducacion();
    });
  }
  eliminarEducacion(id: string){
    this.EducacionService.deleteEducacion(id).subscribe(
      res=>{this.listarEducacion();}
    );
  }

}
