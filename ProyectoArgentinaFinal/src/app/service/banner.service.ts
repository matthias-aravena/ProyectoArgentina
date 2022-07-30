import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Banner } from "../Model/banner.model";


@Injectable({
    providedIn: 'root'
})

export class bannerService {
    url='https://argentinaprograma04.herokuapp.com/banner/banners';
    constructor(private http: HttpClient) { }

    getBanners():Observable<any>{
        return this.http.get(this.url)
    }

    getunBanner(id: string):Observable<any>{
        return this.http.get<any>(this.url+'/'+id);
    }
    guardarBanner(banner: Banner):Observable<any>{
        return this.http.post(this.url, banner);
    }
    editarBanner(id: string, banner: Banner):Observable<any>{
        return this.http.put<any>(this.url+'/'+id, banner);
    }

    deleteBanner(id:string):Observable<any>{
        return this.http.delete(this.url+'/'+id);
    }
}
