package com.example.taskifybackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<UserData, Integer> {
    public UserData findByEmail(String email);

}