package com.jgranados.calcappapi.operations.services;

import com.jgranados.calcappapi.operations.api.model.OperationApiModel;
import com.jgranados.calcappapi.operations.db.DBCalculator;
import com.jgranados.calcappapi.operations.domain.Historial;

/**
 *
 * @author jose
 */
public class Calculator {

    private OperationApiModel apiModel;
    private DBCalculator dbCalculator;
    
    public Calculator(OperationApiModel apiModel, DBCalculator dbCalculator) {
        this.apiModel = apiModel;
        this.dbCalculator = dbCalculator;
    }
    
    public String executeOperation() throws CalculatorException {
        try {
            switch (apiModel.getOperation()) {
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
                    throw new CalculatorException("No se reconoce la operacion: " + apiModel.getOperation());
            }
            
            
        } catch (IllegalArgumentException e) {
            throw new CalculatorException("No se reconoce la operacion: " + apiModel.getOperation());
        } catch (NullPointerException e) {
            throw new CalculatorException("No se permite dejar en blanco la operacion");
        }
    }
    
    public Historial executeOperationAndSaveHistorial() throws CalculatorException {
        Historial newHistorial = new Historial();
        newHistorial.setNumero1(apiModel.getNumber1());
        newHistorial.setNumero2(apiModel.getNumber2());
        newHistorial.setOperacion(apiModel.getOperation());
        newHistorial.setResultado(executeOperation());
        
        dbCalculator.save(newHistorial);
        
        return newHistorial;
    }
    
    private int add() {
        return apiModel.getNumber1() + apiModel.getNumber2();
    }
    
    private int multi() {
        return apiModel.getNumber1() * apiModel.getNumber2();
    }
    
    private int getGreater() {
        return apiModel.getNumber1() >= apiModel.getNumber2() ? apiModel.getNumber1() : apiModel.getNumber2();
    }
    
    private double pow() {
        return Math.pow(apiModel.getNumber1(), apiModel.getNumber2());
    }
    
    private String convertBinary() {
        return Integer.toBinaryString(apiModel.getNumber1()) + ", " + Integer.toBinaryString(apiModel.getNumber2());
    }
}
