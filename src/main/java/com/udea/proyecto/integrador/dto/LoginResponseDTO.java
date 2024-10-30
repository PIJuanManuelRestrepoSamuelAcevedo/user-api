package com.udea.proyecto.integrador.dto;

public class LoginResponseDTO {
    String username;

    public LoginResponseDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
