import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Proyecto } from "../Model/proyecto.model";



@Injectable({
    providedIn: 'root'
})

export class proyectoService {
    url='https://argentinaprograma04.herokuapp.com/proyecto/proyectos';
    constructor(private http: HttpClient) { }

    getProyectos():Observable<any>{
        return this.http.get(this.url)
    }

    getunProyecto(id: string):Observable<any>{
        return this.http.get<any>(this.url+'/'+id);
    }
    guardarProyecto(proyecto: Proyecto):Observable<any>{
        return this.http.post(this.url, proyecto);
    }
    editarProyecto(id: string, proyecto: Proyecto):Observable<any>{
        return this.http.put<any>(this.url+'/'+id, proyecto);
    }

    deleteProyecto(id:string):Observable<any>{
        return this.http.delete(this.url+'/'+id);
    }
}

