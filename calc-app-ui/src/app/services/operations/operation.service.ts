import { Historial } from './../../../objects/calculator/Historial';
import { OperationResponse } from './../../../objects/calculator/OperationResponse';
import { Operation } from '../../../objects/calculator/Operation';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OperationService {

  readonly API_URL = "http://localhost:8081/calc-app-api/";

  @Output()
  emisorDeCambios: EventEmitter<Historial> = new EventEmitter();

  constructor(private httpClient: HttpClient) { }

  public createOperation(operation: Operation): Observable<OperationResponse> {
    return this.httpClient.post<OperationResponse>(this.API_URL + "operations", operation);
  }

  public updateOperation(data: Historial): Observable<void> {
    return this.httpClient.put<void>(this.API_URL + "operations", data);
  }

  public getAllHistorial(): Observable<Historial[]> {
    return this.httpClient.get<Historial[]>(this.API_URL + "operations");
  }
}
