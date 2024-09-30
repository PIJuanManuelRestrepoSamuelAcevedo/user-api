package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.dto.UserDTO;
import com.udea.proyecto.integrador.entitiy.User;

public interface UserService {

    UserDTO getUser(Long userId);
    UserDTO registerUser(User user);
    void registerWallet(Long userId, String walletId);
    String getUserAddress(Long userId);
}
