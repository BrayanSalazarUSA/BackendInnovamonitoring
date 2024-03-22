package com.innovamonitoring.models.dto;

import java.io.Serializable;

public class AgentUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private boolean deleted;
    private String name;
    private String email;
    private String image;
    private String roleName;

    // Constructor vacío necesario para JPA y para uso general
    public AgentUserDTO() {
    }

    // Constructor completo
    public AgentUserDTO(Long userId, boolean deleted, String name, String email, String image, String roleName) {
        this.userId = userId;
        this.deleted = deleted;
        this.name = name;
        this.email = email;
        this.image = image;
        this.roleName = roleName;
    }

    // Getters y setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
