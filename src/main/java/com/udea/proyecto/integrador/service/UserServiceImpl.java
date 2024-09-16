package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.entitiy.User;
import com.udea.proyecto.integrador.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            throw new RuntimeException();
        }
        return user.get();
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void registerWallet(Long userId, String walletId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new RuntimeException();
        }
        User userAux = user.get();
        userAux.setWallet(walletId);
        userRepository.save(userAux);
    }
}
