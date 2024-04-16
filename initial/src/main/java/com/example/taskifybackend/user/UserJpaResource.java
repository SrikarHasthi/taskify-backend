package com.example.taskifybackend.user;

import com.example.taskifybackend.todohistory.TodoHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserJpaResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<UserData> retrieveUsers(){
        return userRepository.findAll();
    };

    @GetMapping("/users/{id}")
    public UserData retrieveUser(@PathVariable Integer id){
        Optional<UserData> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @GetMapping("/users/{id}/todohistory")
    public List<TodoHistory> retrieveAllHistory(@PathVariable Integer id){
        Optional<UserData> user = userRepository.findById(id);
        return user.get().getTodoHistory();
    }

    @PostMapping("/users")
    public UserData createUser(@RequestBody UserData userData){
        userData.setUserId(null);
        return userRepository.save(userData);
//        Todo newTodo = todoRepository.save(todo.getSummary(), todo.getDescription(), todo.getPriority(), todo.getTime(), todo.getStatus());
//        return todo;

    };

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserData request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        try {
            jdbcTemplate.update(
                    "INSERT INTO user_data (name, email, password, enabled) VALUES (?, ?, ?, ?)",
                    request.getName(), request.getEmail(), encodedPassword, 1);
            jdbcTemplate.update(
                    "INSERT INTO authorities (email, authority) VALUES (?, ?)",
                    request.getEmail(), "ROLE_USER");

            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
    }
}
