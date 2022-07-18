import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/Model/skill.model';
import { skillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-hard-skills',
  templateUrl: './hard-skills.component.html',
  styleUrls: ['./hard-skills.component.css']
})


export class HardSkillsComponent implements OnInit {

  lista:any=[];
  nuevoSkill: Skill={id:'', nombreSkill:'', imagenSkill:'', porcentajeSkill:''};
  constructor(private SkillService: skillService) { }

  ngOnInit(): void {
    this.listarSkill();
  }
  listarSkill(){
    this.SkillService.getSkills().subscribe(
      res=>{this.lista=res}
    );
  }
  agregarSkill(){
    this.SkillService.guardarSkill(this.nuevoSkill).subscribe(res=>{
      this.listarSkill();
    });
  }
  eliminarSkill(id: string){
    this.SkillService.deleteSkill(id).subscribe(
      res=>{this.listarSkill();}
    );
  }
}
