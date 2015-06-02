package com.isil.am2.exampledatosabiertos.model.entity;

import java.io.Serializable;

/**
 * Created by emedinaa on 26/05/2015.
 */
public class SitioARQEntity implements Serializable {

    private String identificador;
    private String nombre;
    private String descripcion;
    private String distrito;


    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
