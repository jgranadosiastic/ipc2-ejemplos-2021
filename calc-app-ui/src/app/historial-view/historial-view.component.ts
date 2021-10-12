import { OperatorEnum } from './../../objects/calculator/OperatorEnum';
import { Historial } from './../../objects/calculator/Historial';
import { OperationService } from './../services/operations/operation.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-historial-view',
  templateUrl: './historial-view.component.html',
  styleUrls: ['./historial-view.component.css']
})
export class HistorialViewComponent implements OnInit {

  historial: Historial;

  constructor(private operationService: OperationService) {
    this.historial = new Historial(0, 0, 0, OperatorEnum.ADD, "");
   }

  ngOnInit(): void {
    this.operationService.emisorDeCambios.subscribe((data: Historial) => {
      console.log(data);
      this.historial = data;
    });
  }

}
