import { OperationResponse } from './../../objects/calculator/OperationResponse';
import { Operation } from './../../objects/calculator/Operation';
import { OperationService } from './../services/operations/operation.service';
import { OperatorEnum } from './../../objects/calculator/OperatorEnum';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-operation-form',
  templateUrl: './operation-form.component.html',
  styleUrls: ['./operation-form.component.css']
})
export class OperationFormComponent implements OnInit {

  operation: Operation;
  eOperatorEnum = OperatorEnum;
  showError: boolean = false;
  showSuccess: boolean = false;
  operationForm!: FormGroup;
  message: String = "";


  constructor(private formBuilder: FormBuilder, private operationService: OperationService) {
    this.operation = new Operation(0, 0, OperatorEnum.ADD);
   }

  ngOnInit(): void {
    this.operationForm = this.formBuilder.group({
      number1: [null, Validators.required],
      number2: [null, Validators.required],
      operation: [null, Validators.required]
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
      this.operation.number1 = this.operationForm.value.number1;
      this.operation.number2 = this.operationForm.value.number2;
      this.operation.operation = this.operationForm.value.operation;
      this.operationService.createOperation(this.operation)
      .subscribe((created: OperationResponse) => {
        this.operationForm.reset({
          "number1": null,
          "number2": null,
          "operation": null
        });
        console.log("created");
        console.log(created);
        this.showError = false;
        this.showSuccess = true;
        this.message = "El resultado es " + created.result;
      }, (error: any) => {
        console.log("hubo un error");
        console.log(error);
        this.showError = true;
        this.message = error.error.message;


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
