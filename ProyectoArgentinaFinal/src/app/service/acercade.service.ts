import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Acercade } from "../Model/acercade.model";



@Injectable({
    providedIn: 'root'
})

export class acercadeService {
    url='http://localhost:8080/acercade/acerca';
    constructor(private http: HttpClient) { }

    getAcercade():Observable<any>{
        return this.http.get(this.url)
    }

    getunAcercade(id: string):Observable<any>{
        return this.http.get<any>(this.url+'/'+id);
    }
    guardarAcercade(acercade: Acercade):Observable<any>{
        return this.http.post(this.url, acercade);
    }
    editarAcercade(id: string, acercade: Acercade):Observable<any>{
        return this.http.put<any>(this.url+'/'+id, acercade); 
    }

    deleteAcercade(id:string):Observable<any>{
        return this.http.delete(this.url+'/'+id);
    }
}
