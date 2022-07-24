import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Acercade } from 'src/app/Model/acercade.model';

import { acercadeService } from 'src/app/service/acercade.service';

@Component({
  selector: 'app-acercaedit',
  templateUrl: './acercaedit.component.html',
  styleUrls: ['./acercaedit.component.css'],
})
export class AcercaeditComponent implements OnInit {
  id: string = '';
  editAcercade: Acercade = { id: '', nombre: '', titulo: '', sobreMi: ''};

  constructor(
    private AcercadeService: acercadeService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.AcercadeService.getunAcercade(this.id).subscribe((data) => {
      this.editAcercade = data;
    });
  }
  modificarAcercade() {
    this.AcercadeService.editarAcercade(this.id, this.editAcercade).subscribe(
      (data) => {
        this.router.navigate(['/home']);
      }
    );
  }
}
