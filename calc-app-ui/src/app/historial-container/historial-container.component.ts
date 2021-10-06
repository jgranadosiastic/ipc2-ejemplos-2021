import { OperatorEnum } from './../../objects/calculator/OperatorEnum';
import { Historial } from './../../objects/calculator/Historial';
import { OperationService } from './../services/operations/operation.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-historial-container',
  templateUrl: './historial-container.component.html',
  styleUrls: ['./historial-container.component.css']
})
export class HistorialContainerComponent implements OnInit {

  listadoHistorial: Historial[] = [];

  constructor(private operationService: OperationService) {
    /*operationService.getAllHistorial()
    .subscribe((listadoHistorial: Historial[]) => {
      this.listadoHistorial = listadoHistorial;
    });*/
    this.listadoHistorial = [
      new Historial(1, 25, 100, OperatorEnum.ADD, "125"),
      new Historial(1, 25, 100, OperatorEnum.ADD, "75")
    ];
  }

  ngOnInit(): void {
  }

}
