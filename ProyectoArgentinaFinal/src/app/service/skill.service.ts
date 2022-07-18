import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Skill } from "../Model/skill.model";




@Injectable({
    providedIn: 'root'
})

export class skillService {
    url='http://localhost:8080/skill/skills';
    constructor(private http: HttpClient) { }

    getSkills():Observable<any>{
        return this.http.get(this.url)
    }

    getunSkill(id: string):Observable<any>{
        return this.http.get<any>(this.url+'/'+id);
    }
    guardarSkill(skill: Skill):Observable<any>{
        return this.http.post(this.url, skill);
    }
    editarSkill(id: string, skill: Skill):Observable<any>{
        return this.http.put<any>(this.url+'/'+id, skill);
    }

    deleteSkill(id:string):Observable<any>{
        return this.http.delete(this.url+'/'+id);
    }
}
