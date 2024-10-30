package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.dto.UserDTO;
import com.udea.proyecto.integrador.entitiy.User;

public interface UserService {

    UserDTO getUser(Long userId);
    UserDTO registerUser(User user);
    String getUserIdFromUsername(String username);
    void registerWallet(Long userId, String walletId);
    String getUserWallet(Long userId);
}
