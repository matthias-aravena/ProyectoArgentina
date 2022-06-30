import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcercaeditComponent } from './components/acercaedit/acercaedit.component';
import { AcercaeditsobremiComponent } from './components/acercaeditsobremi/acercaeditsobremi.component';
import { EdueditarComponent } from './components/edueditar/edueditar.component';
import { ExperiEditarComponent } from './components/experi-editar/experi-editar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'editexperiencia/:id', component: ExperiEditarComponent},
  {path: 'editeducacion/:id', component: EdueditarComponent },
  {path: 'editacerca/:id', component: AcercaeditComponent},
  {path: 'editsobremi/:id', component: AcercaeditsobremiComponent},
  {path: '', redirectTo:'home', pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
