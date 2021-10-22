package com.jgranados.calcappapi.asignaciones.domain;

import java.util.Date;

/**
 *
 * @author jose
 */
public class Estudiante {

    private String carnet;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;

    public Estudiante() {
    }

    
    
    public Estudiante(String carnet, String nombre, String apellidos, Date fechaNacimiento) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
