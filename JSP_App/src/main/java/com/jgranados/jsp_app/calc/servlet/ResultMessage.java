package com.jgranados.jsp_app.calc.servlet;

/**
 *
 * @author jose
 */
public class ResultMessage {

    private String result;
    private String errorMsg;
    private boolean error;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    
}
