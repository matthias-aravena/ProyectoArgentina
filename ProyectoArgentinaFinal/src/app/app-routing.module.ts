import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegistroComponent } from './auth/registro/registro.component';
import { AcercaeditComponent } from './components/acercaedit/acercaedit.component';
import { AcercaeditsobremiComponent } from './components/acercaeditsobremi/acercaeditsobremi.component';
import { EdueditarComponent } from './components/edueditar/edueditar.component';
import { ExperiEditarComponent } from './components/experi-editar/experi-editar.component';
import { HomeComponent } from './components/home/home.component';
import { ProyeditComponent } from './components/proyedit/proyedit.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'editexperiencia/:id', component: ExperiEditarComponent},
  {path: 'editeducacion/:id', component: EdueditarComponent },
  {path: 'editacerca/:id', component: AcercaeditComponent},
  {path: 'editsobremi/:id', component: AcercaeditsobremiComponent},
  {path: 'editproyecto/:id', component: ProyeditComponent},
  {path: '', redirectTo:'home', pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
