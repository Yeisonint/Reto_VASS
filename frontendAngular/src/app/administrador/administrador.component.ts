import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css']
})
export class AdministradorComponent implements OnInit {

  Administradores: string[] = [];
   
  constructor(private httpClientService:HttpClientService) { }

  ngOnInit() {
    this.httpClientService.getAdministradores().subscribe(
      (response: any) =>this.handleSuccessfulResponse(response),
    );
  }
    handleSuccessfulResponse(response: string[])
    {
        this.Administradores=response;
    }
}
