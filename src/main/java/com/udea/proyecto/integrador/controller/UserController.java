package com.udea.proyecto.integrador.controller;

import com.udea.proyecto.integrador.dto.UserDTO;
import com.udea.proyecto.integrador.entitiy.User;
import com.udea.proyecto.integrador.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    ResponseEntity<UserDTO> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping
    ResponseEntity<UserDTO> registerUser(@RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PutMapping
    ResponseEntity<String> registerWallet(@PathVariable Long userId, @PathVariable String walletId){
        userService.registerWallet(userId, walletId);
        return ResponseEntity.ok("wallet registrada...");
    }

    @GetMapping("/{userId}/address")
    ResponseEntity<String> getUserAddress(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserAddress(userId));
    }
}
