package com.udea.proyecto.integrador.dto;

import jakarta.validation.constraints.NotNull;

public class LoginDTO {
    @NotNull(message = "el usuario no puede ser nulo.")
    String username;
    @NotNull(message = "la clave no puede ser nula.")
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
