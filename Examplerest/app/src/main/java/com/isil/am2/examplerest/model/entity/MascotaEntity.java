package com.isil.am2.examplerest.model.entity;

import java.io.Serializable;

/**
 * Created by emedinaa on 26/05/2015.
 */
public class MascotaEntity implements Serializable {

    private String objectId;
    private String name;
    private String detalle;
    private String idUser;
    private boolean estado;
    private String fec_encontrado;
    private String fec_extravio;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFec_encontrado() {
        return fec_encontrado;
    }

    public void setFec_encontrado(String fec_encontrado) {
        this.fec_encontrado = fec_encontrado;
    }

    public String getFec_extravio() {
        return fec_extravio;
    }

    public void setFec_extravio(String fec_extravio) {
        this.fec_extravio = fec_extravio;
    }
}
