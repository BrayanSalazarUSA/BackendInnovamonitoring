package com.innovamonitoring.models.dto;

import java.io.Serializable;

public class PropertyUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String direction;
    private String img;

    // Constructor vacío necesario para JPA
    public PropertyUserDTO() {
    }

    public PropertyUserDTO(Long id, String name, String direction, String img) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.img = img;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
