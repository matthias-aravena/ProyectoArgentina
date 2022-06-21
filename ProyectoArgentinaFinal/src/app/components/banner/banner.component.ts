import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Banner } from 'src/app/Model/banner.model';
import { bannerService } from 'src/app/service/banner.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {
  lista:any=[];
  id: string ="";
  editBanner:  Banner={id:'',imagenBanner: ''};
  constructor(private BannerService: bannerService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id= this.activatedRoute.snapshot.params['id'];
    this.BannerService.getunBanner(this.id).subscribe(
      data=>{this.editBanner=data;}
    );
    this.listarBanner();
  }
  listarBanner(){
    this.BannerService.getBanners().subscribe(
      res=>{this.lista=res}
    );
  }
  modificarBanner(){
    this.BannerService.editarBanner(this.id, this.editBanner).subscribe(
      data=>{
      this.router.navigate(['/home']);}
     );
    }

}
