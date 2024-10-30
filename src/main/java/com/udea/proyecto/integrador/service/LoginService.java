package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.dto.LoginResponseDTO;
import com.udea.proyecto.integrador.entitiy.User;

public interface LoginService {

    LoginResponseDTO loginUser(String username, String password) throws Exception;
    String registerUser(User user);
}
