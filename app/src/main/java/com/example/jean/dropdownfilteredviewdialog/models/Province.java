package com.example.jean.dropdownfilteredviewdialog.models;

/**
 * Created by Jean on 24/11/2015.
 */
public class Province {

    private long id;
    private String name;

    public Province(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
