package com.udea.proyecto.integrador.controller;

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
    ResponseEntity<User> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/{userId}/wallet")
    ResponseEntity<String> getUserWallet(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUsersWallet(userId));
    }

    @GetMapping("/{username}/user_id")
    ResponseEntity<String> getUserIdFromUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserIdFromUsername(username));
    }

    @PostMapping
    ResponseEntity<User> registerUser(@RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PutMapping("/{userId}/wallet/{walletAddress}")
    ResponseEntity<String> registerWallet(@PathVariable Long userId, @PathVariable String walletAddress){
        userService.registerWallet(userId, walletAddress);
        return ResponseEntity.ok("wallet registrada...");
    }
}
