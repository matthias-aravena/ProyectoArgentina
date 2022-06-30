import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Acercade } from 'src/app/Model/acercade.model';
import { persona } from 'src/app/Model/persona.model';
import { acercadeService } from 'src/app/service/acercade.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css']
})
export class AcercadeComponent implements OnInit {
  lista:any=[];
  nuevoAcercade: Acercade={id:'', nombre:'', titulo:'', sobreMi:''};


persona: persona = new persona(" "," "," ");
image = '';
imgUrl = 'assets/portfolio.png' ;
  constructor(public personaService: PersonaService,
               private htttp:HttpClient,
               private AcercadeService: acercadeService) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => {this.persona = data}),
    this.listarAcercade();

}
  listarAcercade(){
    this.AcercadeService.getAcercade().subscribe(
      res=>{this.lista=res}
    );
  }
  agregarAcercade(){
    this.AcercadeService.guardarAcercade(this.nuevoAcercade).subscribe(res=>{
      this.listarAcercade();
    });
  }
  eliminarAcercade(id: string){
    this.AcercadeService.deleteAcercade(id).subscribe(
      res=>{this.listarAcercade();}
    );
  }






  selectImage(event: any): void{
    console.log(event);
   if(event.target.files.length > 0){
   const file = event.target.files[0];
   const reader = new FileReader();
   reader.readAsDataURL(file);
  reader.onload = (event: any) =>{
  this.imgUrl = event.target.result;
   }
   this.image= file;

   }
  }
  onSubmit(){

  }
}
