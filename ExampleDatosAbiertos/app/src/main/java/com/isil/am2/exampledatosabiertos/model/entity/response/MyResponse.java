package com.isil.am2.exampledatosabiertos.model.entity.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 2/06/15.
 */
public class MyResponse implements Serializable {

    private String id;
    private String title;
    private String description;
    private String user;
    private List<ArrayList<String>> result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<ArrayList<String>> getResult() {
        return result;
    }

    public void setResult(List<ArrayList<String>> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user='" + user + '\'' +
                ", result=" + result +
                '}';
    }
}
