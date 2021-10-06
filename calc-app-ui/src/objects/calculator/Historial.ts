import { OperatorEnum } from './OperatorEnum';
export class Historial {

    idHistorial: Number;
    numero1: Number;
    numero2: Number;
    operacion: OperatorEnum;
    resultado: string;



    constructor(idHistorial: Number, numero1: Number, numero2: Number, operacion: OperatorEnum, resultado: string) {
        this.idHistorial = idHistorial;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacion = operacion;
        this.resultado = resultado;
    }

    get getidHistorial() {
      return this.idHistorial
    }
    
    set setidHistorial(val: Number) {
      this.idHistorial = val
    }
    
    get getnumero1() {
      return this.numero1
    }
    
    set setnumero1(val: Number) {
      this.numero1 = val
    }
    
    get getnumero2() {
      return this.numero2
    }
    
    set setnumero2(val: Number) {
      this.numero2 = val
    }
    
    get getoperacion() {
      return this.operacion
    }
    
    set setoperacion(val: OperatorEnum) {
      this.operacion = val
    }
    
    get getresultado() {
      return this.resultado
    }
    
    set setresultado(val: string) {
      this.resultado = val
    }

    

}