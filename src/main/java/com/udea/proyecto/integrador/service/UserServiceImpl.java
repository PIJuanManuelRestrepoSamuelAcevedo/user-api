package com.udea.proyecto.integrador.service;

import com.udea.proyecto.integrador.config.ApiException;
import com.udea.proyecto.integrador.dto.UserDTO;
import com.udea.proyecto.integrador.entitiy.User;
import com.udea.proyecto.integrador.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            throw new ApiException("User not found.");
        }
        return getUserDto(user.get());
    }

    @Override
    public UserDTO registerUser(User user) {
        return getUserDto(userRepository.save(user));
    }

    @Override
    public String getUserIdFromUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(value -> value.getUserId().toString()).orElseThrow(() -> new ApiException("User not found."));
    }

    @Override
    public void registerWallet(Long userId, String walletId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new ApiException("User not found.");
        }
        User userAux = user.get();
        userAux.setWallet(walletId);
        userRepository.save(userAux);
    }

    @Override
    public String getUserWallet(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            throw new ApiException("User not found.");
        }
        return user.get().getWallet();
    }

    public UserDTO getUserDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User getUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
