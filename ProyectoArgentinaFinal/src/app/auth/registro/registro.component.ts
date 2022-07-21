import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NuevoUsuariop } from 'src/app/modelos/nuevo-usuariop';
import { AuthService } from 'src/app/service/auth.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  isLogged = false;
  isRegister = false;
  isRegisterFail = false;
  nuevoUsuariop: NuevoUsuariop;
  nombre: string;
  nombreUsuariop: string;
  email: string;
  password: string;
  errMsj: string;
  constructor(private tokenService: TokenService,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;

    }
  }

  onRegister(): void {
    this.nuevoUsuariop = new NuevoUsuariop(this.nombre, this.nombreUsuariop,this.email, this.password);
    this.authService.nuevo(this.nuevoUsuariop).subscribe(
      { next: data => {
        this.isRegister = true;
        this.isRegisterFail = false;
        this.router.navigate(['/login']);
      },
      error: err => {
        this.isRegister = false;
        this.isRegisterFail = true;
        this.errMsj = err.error.mensaje;
        console.log(this.errMsj);
      }
    });
  }
}
