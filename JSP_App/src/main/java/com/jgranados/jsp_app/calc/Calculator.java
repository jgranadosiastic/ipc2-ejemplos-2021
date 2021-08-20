package com.jgranados.jsp_app.calc;

/**
 *
 * @author jose
 */
public class Calculator {

    private int number1;
    private int number2;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) throws CalculatorException {
        try {
            this.number1 = Integer.valueOf(number1);
        } catch (NumberFormatException e) {
            throw new CalculatorException("El valor del numero 1 es incorrecto");
        }
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) throws CalculatorException {
        try {
            this.number2 = Integer.valueOf(number2);
        } catch (NumberFormatException e) {
            throw new CalculatorException("El valor del numero 2 es incorrecto");
        }
    }
    
    public String executeOperation(String operationStr) throws CalculatorException {
        try {
            Operation operation = Operation.valueOf(operationStr);
            switch (operation) {
                case ADD:
                    return String.valueOf(add());
                case MULTI:
                    return String.valueOf(multi());
                case GREATER:
                    return String.valueOf(getGreater());
                case POW:
                    return String.valueOf(pow());
                case BINARY:
                    return String.valueOf(convertBinary());
                default:
                    throw new CalculatorException("No se reconoce la operacion: " + operationStr);
            }
            
            
        } catch (IllegalArgumentException e) {
            throw new CalculatorException("No se reconoce la operacion: " + operationStr);
        } catch (NullPointerException e) {
            throw new CalculatorException("No se permite dejar en blanco la operacion");
        }
    }
    
    private int add() {
        return number1 + number2;
    }
    
    private int multi() {
        return number1 * number2;
    }
    
    private int getGreater() {
        return number1 >= number2 ? number1 : number2;
    }
    
    private double pow() {
        return Math.pow(number1, number2);
    }
    
    private String convertBinary() {
        return Integer.toBinaryString(number1) + ", " + Integer.toBinaryString(number2);
    }
}
