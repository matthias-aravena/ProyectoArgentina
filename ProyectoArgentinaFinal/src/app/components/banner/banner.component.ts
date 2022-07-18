import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { bannerService } from 'src/app/service/banner.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {
  imageBanner = '';
  imgURL = 'assets/portfolio.png';
  constructor(private BannerService: bannerService,
              private http:HttpClient) { }

  ngOnInit(): void {}


  selectImageBanner(event: any){
    console.log(event);
   if(event.target.files.length > 0){
   const file = event.target.files[0];
   const reader = new FileReader();
   reader.readAsDataURL(file);
  reader.onload = (event: any) =>{
  this.imgURL = event.target.result;
   }
   this.imageBanner= file;

   }
  }
  onSubmit(){

  }
}
