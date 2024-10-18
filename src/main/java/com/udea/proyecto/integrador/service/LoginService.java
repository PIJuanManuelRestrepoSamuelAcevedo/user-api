package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.entitiy.User;

public interface LoginService {

    boolean loginUser(String username, String password);
    String registerUser(User user);
}
