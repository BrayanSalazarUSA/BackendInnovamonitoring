package com.innovamonitoring.models.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;

    // Constructor vacío necesario para JPA
    public RoleDTO() {
    }

    // Constructor completo
    public RoleDTO(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
