package com.isil.am2.examplelistviewadapter.model.entity;

import java.io.Serializable;

/**
 * Created by emedinaa on 14/04/15.
 */
public class ProductEntity implements Serializable {

    private int id;
    private String name;
    private String model;
    private boolean stock;
    private float price;

    public ProductEntity(int id, String name, String model, boolean stock, float price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
