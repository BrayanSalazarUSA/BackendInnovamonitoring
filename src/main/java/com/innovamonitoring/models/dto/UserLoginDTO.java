package com.innovamonitoring.models.dto;

import java.io.Serializable;
import java.util.List;
public class UserLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String name;
    private String image;
    private RoleDTO role;
    private List<PropertyUserDTO> properties;

    // Constructor vacío
    public UserLoginDTO() {
    }

    // Constructor con campos
    public UserLoginDTO(Long id, String email, String name, String image, RoleDTO role, List<PropertyUserDTO> properties) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.image = image;
        this.role = role;
        this.properties = properties;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public List<PropertyUserDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyUserDTO> properties) {
        this.properties = properties;
    }
}