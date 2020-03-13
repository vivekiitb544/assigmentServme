package com.servme.todoapp.controller;
import com.servme.todoapp.auth.model.CustomSpringUser;
import com.servme.todoapp.auth.model.User;
import com.servme.todoapp.model.TodoItem;
import com.servme.todoapp.repository.TodoItemRepository;
import com.servme.todoapp.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class TodoListController {

    @Autowired
    private TodoItemService todoItemService;

    public TodoListController() {
    }

    // New todo item
    @PostMapping(value = "/create/todo")
    public ResponseEntity<TodoItem> newTodoItem(@RequestBody TodoItem item, Authentication authentication) {
        //Todo: Need to have proper exceptional handling
        if(item == null || item.getCategoryId() == null){
            return ResponseEntity.badRequest().build();
        }
        Long userId = ((CustomSpringUser) authentication.getPrincipal()).getUserId();
        return ResponseEntity.ok(todoItemService.saveTodoItem(item, userId));
    }


    @RequestMapping(value = "/list/todo", method = RequestMethod.GET)
    public ResponseEntity<List<TodoItem>> getTodoItems(Authentication authentication) {
        Long userId = ((CustomSpringUser) authentication.getPrincipal()).getUserId();
        return ResponseEntity.ok(todoItemService.getTodoList(userId));
    }

    @PutMapping (value = "/update/todo")
    public ResponseEntity<TodoItem> updateTodoStatus(@RequestBody TodoItem item, Authentication authentication) {
        if(item == null || item.getStatus() == null || item.getId() ==null){
            return ResponseEntity.badRequest().build();
        }
        Long userId = ((CustomSpringUser) authentication.getPrincipal()).getUserId();
        return ResponseEntity.ok(todoItemService.updateTodoStatus(item.getId(), item.getStatus(), userId));
    }


}
