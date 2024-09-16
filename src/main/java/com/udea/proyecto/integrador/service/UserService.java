package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.entitiy.User;

public interface UserService {

    User getUser(Long userId);
    User registerUser(User user);
    void registerWallet(Long userId, String walletId);
}
