import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Administrador {
  constructor(
    public id: string,
    public usuario: string,
    public clave: string,
    public rol: string,
    public salario: string,
    public porcentaje: string,
    public activo: boolean,
  ) { }
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient: HttpClient) {
  }
  getAdministradores() {
    console.log("test call");
    return this.httpClient.get<Administrador[]>('http://localhost:8080/api/v1/administradores');
  }

}
