package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.entitiy.User;
import com.udea.proyecto.integrador.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserImpl implements LoginService {

    private final UserRepository userRepository;

    public LoginUserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean loginUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    @Override
    public String registerUser(User user) {
        User saveUser = userRepository.save(user);
        return "El usuario con nombre " + saveUser.getName() + " ha sido registrado.";
    }
}
