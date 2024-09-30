package com.udea.proyecto.integrador.service;

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
            throw new RuntimeException();
        }
        return getUserDto(user.get());
    }

    @Override
    public UserDTO registerUser(User user) {
        return getUserDto(userRepository.save(user));
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

    @Override
    public String getUserAddress(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            throw new RuntimeException();
        }
        return user.get().getAddress();
    }

    public UserDTO getUserDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User getUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
