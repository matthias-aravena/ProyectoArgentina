import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/Model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css']
})
export class AcercadeComponent implements OnInit {
persona: persona = new persona(" "," "," ");
image = '';
imgUrl = 'assets/portfolio.png' ;
  constructor(public personaService: PersonaService,
               private htttp:HttpClient ) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => {this.persona = data})
  }
  selectImage(event: any){
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
