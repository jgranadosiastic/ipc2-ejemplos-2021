import { Component, OnInit } from '@angular/core';
import { Operation } from '../../objects/calculator/Operation';

@Component({
  selector: 'app-operation-form',
  templateUrl: './operation-form.component.html',
  styleUrls: ['./operation-form.component.css']
})
export class OperationFormComponent implements OnInit {

  operation: Operation;
  
  constructor() {
    this.operation = new Operation(null, null, null);
   }

  ngOnInit(): void {
  }

  

}
