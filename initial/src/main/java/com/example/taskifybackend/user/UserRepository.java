package com.example.taskifybackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<UserData, Integer> {
    Optional<UserData> findByName(String username);

    Boolean existsByEmail(String email);

    Optional<UserData> findByNameOrEmail(String username, String email);

    boolean existsByName(String username);

}