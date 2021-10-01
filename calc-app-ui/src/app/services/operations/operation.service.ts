import { Operation } from '../../../objects/calculator/Operation';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OperationService {

  readonly API_URL = "http://localhost:8081/calc-app-api/";

  constructor(private httpClient: HttpClient) { }

  public createOperation(operation: Operation): Observable<Operation> {
    return this.httpClient.post<Operation>(this.API_URL + "operations", operation);
  }
}
