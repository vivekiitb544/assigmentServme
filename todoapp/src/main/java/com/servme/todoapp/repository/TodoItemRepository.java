package com.servme.todoapp.repository;


import com.servme.todoapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {


    List<TodoItem> findByUserId(Long userId);
    TodoItem findByIdAndUserId(Long id, Long userId);

}
