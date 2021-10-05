package com.jgranados.calcappapi.operations.api.model;

/**
 *
 * @author jose
 */
public class BackendErrorModel {
    private String message;

    public BackendErrorModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
