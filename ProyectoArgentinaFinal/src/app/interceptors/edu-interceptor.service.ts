import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenService } from '../service/token.service';

@Injectable({
  providedIn: 'root'
})
export class EduInterceptorService implements HttpInterceptor{

  constructor(private tokenService: TokenService,
              private router: Router) { }
   intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const token: string = this.tokenService.getToken();

    let request = req;
    if(token){
      request = req.clone({
        setHeaders:{
          authorization: `Bearer ${token}`
        }
      });
    }
    return next.handle(request);

  }


  }



