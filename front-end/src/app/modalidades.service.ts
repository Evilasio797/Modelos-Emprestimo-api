import { Injectable } from '@angular/core';
import { Modalidades } from './modalidades'
import { Observable } from 'rxjs'
import { HttpClient } from '@angular/common/http'
import { environment } from '../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class ModalidadesService {

  apiURL: string = environment.apiURL
  
  constructor(
    private http: HttpClient
  ) { }

  salvar(modalidades: Modalidades) : Observable<Modalidades>{
    return this.http.post<Modalidades>(this.apiURL, modalidades)

  }

  listar() : Observable<Modalidades[]>{
    return this.http.get<Modalidades[]>(this.apiURL);
  }

}
