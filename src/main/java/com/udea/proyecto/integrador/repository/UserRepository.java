package com.udea.proyecto.integrador.repository;

import com.udea.proyecto.integrador.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
