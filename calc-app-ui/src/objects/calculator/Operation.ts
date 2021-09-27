import { OperatorEnum } from "./OperatorEnum";

export class Operation {
    _number1: number;
    _number2: number;
    _operator: OperatorEnum;

    constructor(number1: number, number2: number, operator: OperatorEnum) {
        this._number1 = number1;
        this._number2 = number2;
        this._operator = operator;
    }

    get number1() {
        return this._number1;
    }

    set number1(number1: number) {
        this._number1 = number1;
    }

    get number2() {
        return this._number2;
    }

    set number2(number2: number) {
        this._number2 = number2;
    }
    
    get operator() {
        return this._operator;
    }

    set operator(operator: OperatorEnum) {
        this._operator = operator;
    }

   
}