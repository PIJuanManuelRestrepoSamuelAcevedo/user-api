package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.dto.LoginResponseDTO;
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
    public LoginResponseDTO loginUser(String username, String password) throws Exception {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                return new LoginResponseDTO(user.get().getUsername());
            }
            throw new Exception("Bad password.");
        } else {
            throw new Exception("user not found.");
        }
    }

    @Override
    public String registerUser(User user) {
        User saveUser = userRepository.save(user);
        return "El usuario con nombre " + saveUser.getName() + " ha sido registrado.";
    }
}
