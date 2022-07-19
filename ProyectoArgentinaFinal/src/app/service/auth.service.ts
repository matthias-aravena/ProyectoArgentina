import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtDTO } from '../modelos/jwt-dto';
import { LoginUsuariop } from '../modelos/login-usuariop';
import { NuevoUsuariop } from '../modelos/nuevo-usuariop';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = 'http://localhost:8080/auth/'
  constructor(private httpClient: HttpClient) { }

  public nuevo(NuevoUsuariop: NuevoUsuariop): Observable<any> {
    return this.httpClient.post<any>(this.authURL + 'nuevo' , NuevoUsuariop);
  }
  public login(loginUsuariop: LoginUsuariop): Observable<JwtDTO>{
   return this.httpClient.post<JwtDTO>(this.authURL + 'login', loginUsuariop);
 }
}
