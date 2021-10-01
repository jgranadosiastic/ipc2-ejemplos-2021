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
  messageFlag: boolean = false;
  operationForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private operationService: OperationService) {
    this.operation = new Operation(0, 0, OperatorEnum.ADD);
   }

  ngOnInit(): void {
    this.operationForm = this.formBuilder.group({
      number1: [null, Validators.required],
      number2: [null, Validators.required],
      operator: [null, Validators.required]
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
      this.operationService.createOperation(this.operationForm.value)
      .subscribe((created: Operation) => {
        this.operationForm.reset({
          "number1": null,
          "number2": null,
          "operator": null
        });
        console.log("created");
        console.log(created);
      }, (error: any) => {
        console.log("hubo un error");
        console.log(console.error());

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
