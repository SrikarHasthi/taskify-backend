package com.example.taskifybackend.todo;


import com.example.taskifybackend.todohistory.TodoHistory;
import com.example.taskifybackend.todohistory.TodoHistoryJpaResource;
import com.example.taskifybackend.todohistory.TodoHistoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoJpaResource {

    private  TodoRepository todoRepository;

    private TodoHistoryJpaResource todoHistoryJpaResource;;

    public TodoJpaResource(TodoRepository todoRepository, TodoHistoryJpaResource todoHistoryJpaResource){
      this.todoRepository = todoRepository;
      this.todoHistoryJpaResource = todoHistoryJpaResource;
    };

//    public TodoJpaResource(TodoRepository todoRepository){
//        this.todoRepository = todoRepository;
//    };


    @GetMapping("/todoss")
    public List<Todo> retrieveTodos(){
        return todoRepository.findAll();
    };

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id){
        todoRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    };


    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        TodoHistory todayTodoHistory = todoHistoryJpaResource.retrieveTodayTodoHistory();
        todo.setTodoHistoryy(todayTodoHistory);
        todoRepository.save(todo);
        return todo;
    };

    @PostMapping("/todoss")
    public Todo createTodo(@RequestBody Todo todo){
        todo.setId(null);
        TodoHistory todayTodoHistory = todoHistoryJpaResource.retrieveTodayTodoHistory();
        todo.setTodoHistoryy(todayTodoHistory);
        todoRepository.save(todo);
        return todo;
//        Todo newTodo = todoRepository.save(todo.getSummary(), todo.getDescription(), todo.getPriority(), todo.getTime(), todo.getStatus());
//        return todo;

    };
}
