package com.example.taskifybackend.todohistory;

import com.example.taskifybackend.todo.Todo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TodoHistoryJpaResource {

    private TodoHistoryRepository todoHistoryRepository;
//    private UserRepository userRepository;

//    public TodoHistoryJpaResource(TodoHistoryRepository todoHistoryRepository,  UserRepository userRepository) {
//        this.todoHistoryRepository = todoHistoryRepository;
//        this.userRepository = userRepository;
//    }

    public TodoHistoryJpaResource(TodoHistoryRepository todoHistoryRepository) {
        this.todoHistoryRepository = todoHistoryRepository;
    }

    @GetMapping("/todohistory/all")
    public List<TodoHistory> retrieveAllTodoHistory(){
        return todoHistoryRepository.findAll();
    };

    @GetMapping("/todohistory/today")
    public TodoHistory retrieveTodayTodoHistory(){
        LocalDate today = LocalDate.now();
        System.out.println(todoHistoryRepository.findByDateCreated(String.valueOf(today)));
        if(todoHistoryRepository.findByDateCreated(String.valueOf(today)) == null) {
            TodoHistory th = createTodayTodoHistory(today.toString());
            System.out.println(th);
            return th;
        }
        return todoHistoryRepository.findByDateCreated(String.valueOf(today));
    };

    public TodoHistory createTodayTodoHistory(String date){
        TodoHistory todoHistory = new TodoHistory();
        todoHistory.setDateCreated(date);
        return todoHistoryRepository.save(todoHistory);
    };
//
//    @GetMapping("/todohistory/{id}")
//    public List<TodoHistory> retrieveUserTodoHistory(@PathVariable int id){
//        return todoHistoryRepository.findByUserDataUserId(id);
//    }

//    @GetMapping("/todohistory/{id}/date")
//    public TodoHistory retrieveUserTodoHistoryByDate(@PathVariable int id){
//        LocalDate today = LocalDate.now();
//        System.out.println(today.toString());
//        return todoHistoryRepository.findByDateCreatedAndUserDataUserId(String.valueOf(today), id);
//    }
//
//    @GetMapping("/users/{id}/posts")
//    public List<TodoHistory> retrievehistory(@PathVariable int id){
//        Optional<UserDetails> user = todoHistoryRepository.findById(id);
//        return user.get().getTodoHistory();
//    }

//    @GetMapping("/users/{id}/todohistoryy")
//    public List<Todo> retrieveAllHistory(@PathVariable int id){
//        LocalDate today = LocalDate.now();
//        System.out.println(today.toString());
//        TodoHistory byDateCreated = todoHistoryRepository.findByDateCreated("2024-02-19");
//    }


}
