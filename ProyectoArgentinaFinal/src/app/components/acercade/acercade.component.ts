import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Acercade } from 'src/app/Model/acercade.model';
import { persona } from 'src/app/Model/persona.model';
import { acercadeService } from 'src/app/service/acercade.service';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css']
})
export class AcercadeComponent implements OnInit {
  lista:any=[];
  nuevoAcercade: Acercade={id:'', nombre:'', titulo:'', sobreMi:''};

  roles: string[];
  isAdmin = false;

persona: persona = new persona(" "," "," ");
image = '';
imgUrl = 'assets/portfolio.png' ;
  constructor(public personaService: PersonaService,
               private htttp:HttpClient,
               private AcercadeService: acercadeService,
               private tokenService: TokenService) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => {this.persona = data}),
    this.listarAcercade();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(rol => {
      if(rol === 'ROLE_ADMIN'){
        this.isAdmin = true;
      }
    });

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
