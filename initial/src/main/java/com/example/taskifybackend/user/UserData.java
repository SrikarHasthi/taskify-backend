package com.example.taskifybackend.user;

import com.example.taskifybackend.todohistory.TodoHistory;
import jakarta.persistence.*;
import java.util.List;


@Table(name = "users")
@Entity
public class UserData {
    public UserData() {
    }

    public UserData(Integer userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "userData")
    private List<TodoHistory> todoHistory;


    public List<TodoHistory> getTodoHistory() {
        return todoHistory;
    }

    public void setTodoHistory(List<TodoHistory> todoHistory) {
        this.todoHistory = todoHistory;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
