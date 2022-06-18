import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExperiEditarComponent } from './components/experi-editar/experi-editar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'editexperiencia/:id', component: ExperiEditarComponent},
  {path: '', redirectTo:'home', pathMatch:'full'}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
