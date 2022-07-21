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
import { EduGuardService as guard} from './guards/edu-guard.service';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'editexperiencia/:id', component: ExperiEditarComponent, canActivate: [guard], data:{ expectedRol: ['admin', 'user']}},
  {path: 'editeducacion/:id', component: EdueditarComponent, canActivate: [guard], data:{ expectedRol: ['admin', 'user']} },
  {path: 'editacerca/:id', component: AcercaeditComponent, canActivate: [guard], data:{ expectedRol: ['admin', 'user']}},
  {path: 'editsobremi/:id', component: AcercaeditsobremiComponent, canActivate: [guard], data:{ expectedRol: ['admin', 'user']}},
  {path: 'editproyecto/:id', component: ProyeditComponent, canActivate: [guard], data:{ expectedRol: ['admin', 'user']}},
  {path: '', redirectTo:'home', pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
