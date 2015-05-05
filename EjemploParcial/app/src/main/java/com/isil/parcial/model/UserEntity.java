package com.isil.parcial.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 5/05/15.
 * Entidad Usuario
 */
public class UserEntity implements Serializable {

    //propiedades

    private String id;
    private String name;
    private String lastname;

    //constructor

    public UserEntity(String id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }


    //métodos de acceso SET y GET

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
