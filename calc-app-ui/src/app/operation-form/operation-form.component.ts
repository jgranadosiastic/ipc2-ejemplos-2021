import { Historial } from './../../objects/calculator/Historial';
import { OperationResponse } from './../../objects/calculator/OperationResponse';
import { Operation } from './../../objects/calculator/Operation';
import { OperationService } from './../services/operations/operation.service';
import { OperatorEnum } from './../../objects/calculator/OperatorEnum';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-operation-form',
  templateUrl: './operation-form.component.html',
  styleUrls: ['./operation-form.component.css'],
})
export class OperationFormComponent implements OnInit {
  @Input()
  data!: Historial;

  edit: boolean = false;

  operation: Operation;
  eOperatorEnum = OperatorEnum;
  showError: boolean = false;
  showSuccess: boolean = false;
  operationForm!: FormGroup;
  message: String = '';

  constructor(
    private formBuilder: FormBuilder,
    private operationService: OperationService
  ) {
    this.operation = new Operation(0, 0, OperatorEnum.ADD);
  }

  ngOnInit(): void {
    this.edit = this.data != null;

    if (this.edit) {
      this.operationForm = this.formBuilder.group({
        id: [],
        number1: [null, Validators.required],
        number2: [null, Validators.required],
        operation: [null, Validators.required],
        result: [null, Validators.required],
      });
    } else {
      this.operationForm = this.formBuilder.group({
        number1: [null, Validators.required],
        number2: [null, Validators.required],
        operation: [null, Validators.required]
      });
    }
  }

  public crearOperacion() {
    /*if (this.validateForm()) {;
      console.log(this.operation);
      console.log("Enviar los datos al servidor");
      this.operation = new Operation(0,0, OperatorEnum.ADD);
    }*/
    if (this.operationForm.valid) {
      console.log(this.operationForm.value);
      console.log('Enviar los datos al servidor');
      this.operation.number1 = this.operationForm.value.number1;
      this.operation.number2 = this.operationForm.value.number2;
      this.operation.operation = this.operationForm.value.operation;
      this.operationService.createOperation(this.operation).subscribe(
        (created: OperationResponse) => {
          this.resetForm();
          console.log('created');
          console.log(created);
          this.showError = false;
          this.showSuccess = true;
          this.message = 'El resultado es ' + created.result;
        },
        (error: any) => {
          console.log('hubo un error');
          console.log(error);
          this.showError = true;
          this.message = error.error.message;
        }
      );
    }
  }

  public guardar() {
    if (this.operationForm.valid) {
      console.log(this.operationForm.value);
      console.log('Enviar los datos al servidor');
      this.data.numero1 = this.operationForm.value.number1;
      this.data.numero2 = this.operationForm.value.number2;
      this.data.operacion = this.operationForm.value.operation;
      this.data.resultado = this.operationForm.value.result;
      this.operationService.updateOperation(this.data).subscribe(
        () => {
          this.resetForm();
          this.showError = false;
          this.showSuccess = true;
          this.message = 'Operacion exitosa';
        },
        (error: any) => {
          console.log('hubo un error');
          console.log(error);
          this.showError = true;
          this.message = error.error.message;
        }
      );
    }
  }

  submit(): void {
    if (this.edit) {
      this.guardar();
    } else {
      this.crearOperacion();
    }
  }

  /*private validateForm(): boolean {
    if (this.operation.operator == null) {
      this.messageFlag = true;
      return false;
    }

    return true;
  }*/

  resetForm(): void {
    if (this.edit) {
      this.operationForm.reset({
        id: this.data.idHistorial,
        number1: this.data.numero1,
        number2: this.data.numero2,
        operation: this.data.operacion,
        result: this.data.resultado,
      });
    } else {
      this.operationForm.reset({
        id: null,
        number1: null,
        number2: null,
        operation: null,
        result: null,
      });
    }
  }
}
