package com.jgranados.calcappapi.asignaciones.domain;

import java.util.List;

/**
 *
 * @author jose
 */
public class CursoReporte {

    private String nombre;
    private String codigo;
    private List<Estudiante> estudiantes;

    public CursoReporte() {
    }
    
    public CursoReporte(String nombre, String codigo, List<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
    
}
