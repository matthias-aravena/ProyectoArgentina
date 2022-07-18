import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Acercade } from 'src/app/Model/acercade.model';
import { acercadeService } from 'src/app/service/acercade.service';

@Component({
  selector: 'app-acercaeditsobremi',
  templateUrl: './acercaeditsobremi.component.html',
  styleUrls: ['./acercaeditsobremi.component.css']
})
export class AcercaeditsobremiComponent implements OnInit {
  id: string ="";
  editSobremi:  Acercade={id:'', nombre: '', titulo:'', sobreMi:''};
  lista:any=[];
  nuevoAcercade: Acercade={id:'', nombre:'', titulo:'', sobreMi:''};
  constructor(private AcercadeService: acercadeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id= this.activatedRoute.snapshot.params['id'];
    this.AcercadeService.getunAcercade(this.id).subscribe(
    data=>{this.editSobremi=data;}
    );
    this.listarAcercade();
  }
  listarAcercade(){
    this.AcercadeService.getAcercade().subscribe(
      res=>{this.lista=res}
    );
  }
  agregarAcercade(){
    this.AcercadeService.guardarAcercade(this.nuevoAcercade).subscribe(data=>{
      this.listarAcercade();
      this.router.navigate(['/home']);
    });
  }
  modificarSobremi(){
    this.AcercadeService.editarAcercade(this.id, this.editSobremi).subscribe(
      data=>{
      this.router.navigate(['/home']);}
     );
   }

}
