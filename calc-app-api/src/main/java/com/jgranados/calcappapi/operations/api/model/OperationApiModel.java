package com.jgranados.calcappapi.operations.api.model;

/**
 *
 * @author jose
 */
public class OperationApiModel {

    private Integer number1;
    private Integer number2;
    private String operator;

    public OperationApiModel(Integer number1, Integer number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    
}
