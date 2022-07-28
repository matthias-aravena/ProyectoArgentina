import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../Model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
url='http://localhost:8080/persona/personas/';

constructor(private http: HttpClient) { }

getPersonas():Observable<any>{
  return this.http.get(this.url)
}

getunaPersona(id: string):Observable<any>{
  return this.http.get<any>(this.url+'/'+id);
}
guardarPersona(persona: Persona):Observable<any>{
  return this.http.post(this.url, persona);
}
editarPersona(id: string, persona: Persona):Observable<any>{
  return this.http.put<any>(this.url+'/'+id, persona);
}

deletePersona(id:string):Observable<any>{
  return this.http.delete(this.url+'/'+id);
}
}
