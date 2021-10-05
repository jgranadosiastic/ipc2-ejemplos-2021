package com.jgranados.calcappapi.operations.api.model;

/**
 *
 * @author jose
 */
public class OperationApiResponseModel {
    private int id;
    private String result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public OperationApiResponseModel(int id, String resultado) {
        this.id = id;
        this.result = resultado;
    }
    
    
}
