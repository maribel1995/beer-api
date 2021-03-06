package com.maribel.beers.entity;

import javax.persistence.Entity;

@Entity
public class Beer {
    private String name;
    private String type;

    public Beer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
