package com.awakeyoyoyo.entity;

public class Privilege {
    private String id;

    private String name;

    private String description;

    public Privilege(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Privilege() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}