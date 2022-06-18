import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Experiencia } from "../Model/experiencia.model";


@Injectable({
    providedIn: 'root'
})

export class experienciaService {
    url='http://localhost:8080/experiencia/experiencias';
    constructor(private http: HttpClient) { }

    getExperiencias():Observable<any>{
        return this.http.get(this.url)
    }

    getunaExperiencia(id: string):Observable<any>{
        return this.http.get<any>(this.url+'/'+id);
    }
    guardarExperiencia(experiencia: Experiencia):Observable<any>{
        return this.http.post(this.url, experiencia);
    }
    editarExperiencia(id: string, experiencia: Experiencia):Observable<any>{
        return this.http.put<any>(this.url+'/'+id, experiencia); 
    }

    deleteExperiencia(id:string):Observable<any>{
        return this.http.delete(this.url+'/'+id);
    }
}

