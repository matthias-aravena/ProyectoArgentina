import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/Model/educacion.model';
import { educacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-edueditar',
  templateUrl: './edueditar.component.html',
  styleUrls: ['./edueditar.component.css']
})
export class EdueditarComponent implements OnInit {
  id: string ="";
  editEducacion:  Educacion={id:'',nombreEducacion: '',descEducacion:''};
  constructor(private EducacionService: educacionService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id= this.activatedRoute.snapshot.params['id'];
    this.EducacionService.getunaEducacion(this.id).subscribe(
      data=>{this.editEducacion=data;}
    );
  }
  modificarEducacion(){
    this.EducacionService.editarEducacion(this.id, this.editEducacion).subscribe(
      data=>{
      this.router.navigate(['/home']);}
     );
    }

}
