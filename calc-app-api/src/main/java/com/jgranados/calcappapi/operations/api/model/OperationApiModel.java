package com.jgranados.calcappapi.operations.api.model;

import com.jgranados.calcappapi.operations.domain.Operation;

/**
 *
 * @author jose
 */
public class OperationApiModel {

    private Integer number1;
    private Integer number2;
    private Operation operation;

    public OperationApiModel(Integer number1, Integer number2, Operation operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public OperationApiModel() {
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
    
}
