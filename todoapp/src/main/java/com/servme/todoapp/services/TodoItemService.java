package com.servme.todoapp.services;

import com.servme.todoapp.constant.TodoStatus;
import com.servme.todoapp.model.Category;
import com.servme.todoapp.model.TodoItem;
import com.servme.todoapp.repository.CategoryRepository;
import com.servme.todoapp.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public TodoItem saveTodoItem(TodoItem item, Long userId) {
        item.setDatetime(new Timestamp(System.currentTimeMillis()));
        if(item.getStatus()==null){
            item.setStatus(TodoStatus.INITIAL);
        }
        item.setUserId(userId);
        item.setCategory(categoryRepository.getOne(item.getCategoryId()));
        return todoItemRepository.save(item);
    }

    public TodoItem updateTodoStatus(Long id, TodoStatus todoStatus, Long userId) {
        TodoItem todoItem = todoItemRepository.findByIdAndUserId(id, userId);
        if(todoItem!= null){
            todoItem.setStatus(todoStatus);
        }
        return todoItemRepository.save(todoItem);
    }

    public List<TodoItem> getTodoList(Long userId){
        return todoItemRepository.findByUserId(userId);
    }



}
