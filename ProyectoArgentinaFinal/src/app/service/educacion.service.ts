import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Educacion } from "../Model/educacion.model";

@Injectable({
    providedIn: 'root'
})

export class educacionService {
    url='https://argentinaprograma04.herokuapp.com/educacion/educaciones';
    constructor(private http: HttpClient) { }

    getEducaciones():Observable<any>{
        return this.http.get(this.url)
    }

    getunaEducacion(id: string):Observable<any>{
        return this.http.get<any>(this.url+'/'+id);
    }
    guardarEducacion(educacion: Educacion):Observable<any>{
        return this.http.post(this.url, educacion);
    }
    editarEducacion(id: string, educacion: Educacion):Observable<any>{
        return this.http.put<any>(this.url+'/'+id, educacion);
    }

    deleteEducacion(id:string):Observable<any>{
        return this.http.delete(this.url+'/'+id);
    }
}
