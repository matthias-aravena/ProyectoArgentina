import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Banner } from 'src/app/Model/banner.model';
import { bannerService } from 'src/app/service/banner.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {
  lista:any=[];
  nuevoBanner: Banner={id:'', imagenBanner:''};

  id: string ="";
  editBanner:  Banner={id:'', imagenBanner: ''};

  roles: string[];
  isAdmin = false;
  imagenBanner = '';
  imgURL = 'assets/portfolio.png';
  constructor(private BannerService: bannerService,
              private http:HttpClient,
              private tokenService: TokenService,
              private router: Router) { }

  ngOnInit(): void {
    this.listarBanner();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(rol => {
      if(rol === 'ROLE_ADMIN'){
        this.isAdmin = true;
      }
    });
  }
  listarBanner(){
    this.BannerService.getBanners().subscribe(
      res=>{this.lista=res}
    );
  }
  agregarBanner(){
    this.BannerService.guardarBanner(this.nuevoBanner).subscribe(res=>{
      this.listarBanner();
    });
  }
  eliminarBanner(id: string){
    this.BannerService.deleteBanner(id).subscribe(
      res=>{this.listarBanner();}
    );
  }
  modificarBanner(){
    this.BannerService.editarBanner(this.id, this.editBanner).subscribe(
      data=>{
      this.router.navigate(['/home']);}
     );
   }





  selectImageBanner(event: any){
    console.log(event);
   if(event.target.files.length > 0){
   const file = event.target.files[0];
   const reader = new FileReader();
   reader.readAsDataURL(file);
  reader.onload = (event: any) =>{
  this.imgURL = event.target.result;
   }
   this.imagenBanner= file;

   }
  }
  onSubmit(){

  }
}
