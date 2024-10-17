package com.udea.proyecto.integrador.controller;

import com.udea.proyecto.integrador.dto.LoginDTO;
import com.udea.proyecto.integrador.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public boolean loginUser(@RequestBody LoginDTO loginDTO) {
        return loginService.loginUser(loginDTO.getUsername(), loginDTO.getPassword());
    }

    @PostMapping("/register")
    public void registerUser() {

    }
}
