package com.jgranados.calcappapi.asignaciones.domain;

import java.util.Date;

/**
 *
 * @author jose
 */
public class AsignacionSinCurso {
    private Date fecha;
    private boolean aprobado;
    
    private Estudiante estudiante;

    public AsignacionSinCurso() {
    }

    public AsignacionSinCurso(Date fecha, boolean aprobado, Estudiante estudiante) {
        this.fecha = fecha;
        this.aprobado = aprobado;
        this.estudiante = estudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
}
