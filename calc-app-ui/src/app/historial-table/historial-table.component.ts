import { OperationService } from './../services/operations/operation.service';
import { Historial } from './../../objects/calculator/Historial';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-historial-table',
  templateUrl: './historial-table.component.html',
  styleUrls: ['./historial-table.component.css']
})
export class HistorialTableComponent implements OnInit {

  listadoHistorial: Historial[] = [];

  constructor(private operationService: OperationService) {
    operationService.getAllHistorial()
    .subscribe((listadoHistorial: Historial[]) => {
      this.listadoHistorial = listadoHistorial;
    });
  }


  ngOnInit(): void {
  }

}
