package com.udea.proyecto.integrador.controller;

import com.udea.proyecto.integrador.dto.LoginDTO;
import com.udea.proyecto.integrador.dto.LoginResponseDTO;
import com.udea.proyecto.integrador.entitiy.User;
import com.udea.proyecto.integrador.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginDTO loginDTO) throws Exception {
        return ResponseEntity.ok(loginService.loginUser(loginDTO.getUsername(), loginDTO.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(loginService.registerUser(user));
    }
}
