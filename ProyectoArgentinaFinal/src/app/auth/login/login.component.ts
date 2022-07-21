import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsuariop } from 'src/app/modelos/login-usuariop';
import { AuthService } from 'src/app/service/auth.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isLogged = false;
  isLoggedFail = false;
  loginUsuariop: LoginUsuariop;
  nombreUsuario: string;
  password: string;
  roles: string[] = [];
  errMsj: string;
  constructor(private tokenService: TokenService,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
      this.isLoggedFail = false;
      this.roles = this.tokenService.getAuthorities();
    }
  }

  onLogin(): void {
    this.loginUsuariop = new LoginUsuariop(this.nombreUsuario, this.password);
    this.authService.login(this.loginUsuariop).subscribe(
      { next: data => {
        this.isLogged = true;
        this.isLoggedFail = false;

        this.tokenService.setToken(data.token);
        this.tokenService.setUserName(data.nombreUsuario);
        this.tokenService.setAuthorities(data.authorities);
        this.roles = data.authorities;
        this.router.navigate(['/home']);
      },
      error: err => {
        this.isLogged = false;
        this.isLoggedFail = true;
        this.errMsj = err.error.mensaje;
        console.log(this.errMsj);
      }
    });
  }

}
