package com.example.taskifybackend.todohistory;

import com.example.taskifybackend.todo.Todo;
import com.example.taskifybackend.user.UserData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity
public class TodoHistory {

    @Id
    @GeneratedValue
    private int todoHistoryId;
    private String dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserData userData;

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    @OneToMany(mappedBy = "todoHistoryy")
    private List<Todo> todos;
    public int getTodoHistoryId() {
        return todoHistoryId;
    }

    public void setTodoHistoryId(int todoHistoryId) {
        this.todoHistoryId = todoHistoryId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
