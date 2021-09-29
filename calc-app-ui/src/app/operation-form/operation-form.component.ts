import { OperatorEnum } from './../../objects/calculator/OperatorEnum';
import { Component, OnInit } from '@angular/core';
import { Operation } from '../../objects/calculator/Operation';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-operation-form',
  templateUrl: './operation-form.component.html',
  styleUrls: ['./operation-form.component.css']
})
export class OperationFormComponent implements OnInit {

  operation: Operation;
  eOperatorEnum = OperatorEnum;
  messageFlag: boolean = false;
  operationForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.operation = new Operation(0, 0, OperatorEnum.ADD);
   }

  ngOnInit(): void {
    this.operationForm = this.formBuilder.group({
      number1: ["2", Validators.required],
      number2: ["44", Validators.required],
      operation: [OperatorEnum.ADD, Validators.required]
    });
  }

  public crearOperacion() {
    /*if (this.validateForm()) {;
      console.log(this.operation);
      console.log("Enviar los datos al servidor");
      this.operation = new Operation(0,0, OperatorEnum.ADD);
    }*/
    if (this.operationForm.valid) {
      console.log(this.operationForm.value);
      console.log("Enviar los datos al servidor");
      this.operationForm.reset({
        "number1": 44,
        "number2": 55,
        "operation": OperatorEnum.MULTI
      });
    }
  }

  /*private validateForm(): boolean {
    if (this.operation.operator == null) {
      this.messageFlag = true;
      return false;
    }

    return true;
  }*/


}
