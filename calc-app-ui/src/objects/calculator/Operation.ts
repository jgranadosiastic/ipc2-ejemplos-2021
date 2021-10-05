import { OperatorEnum } from "./OperatorEnum";

export class Operation {
    number1: number;
    number2: number;
    operation: OperatorEnum;

    constructor(number1: number, number2: number, operation: OperatorEnum) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    get getNumber1() {
        return this.number1;
    }

    set setNumber1(number1: number) {
        this.number1 = number1;
    }

    get getNumber2() {
        return this.number2;
    }

    set setNumber2(number2: number) {
        this.number2 = number2;
    }
    
    get getOperation() {
        return this.operation;
    }

    set setOperation(operation: OperatorEnum) {
        this.operation = operation;
    }

   
}