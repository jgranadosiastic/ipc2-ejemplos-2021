package com.jgranados.calcappapi.operations.domain;

/**
 *
 * @author jose
 */
public class Historial {

    private int idHistorial;
    private int numero1;
    private int numero2;
    private Operation operacion;
    private String resultado;

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public Operation getOperacion() {
        return operacion;
    }

    public void setOperacion(Operation operacion) {
        this.operacion = operacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }
}
