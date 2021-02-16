import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { LoginComponent } from './login/login.component';
import { AdministradorComponent } from './administrador/administrador.component';

const routes: Routes = [
  //{ path: 'login', component: LoginComponent },
  { path:'administradores', component: AdministradorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
