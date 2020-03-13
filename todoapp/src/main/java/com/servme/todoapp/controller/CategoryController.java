package com.servme.todoapp.controller;

import com.servme.todoapp.auth.model.CustomSpringUser;
import com.servme.todoapp.model.Category;
import com.servme.todoapp.model.TodoItem;
import com.servme.todoapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // New todo item
    @PostMapping(value = "/category")
    public ResponseEntity<Category> newTodoItem(@RequestBody Category category) {
        //Todo: Need to have proper exceptional handling
        if(category == null || category.getName() == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }


    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
    public ResponseEntity<List<TodoItem>> getTodoItems(@PathVariable("categoryId") Long categoryId) {
        if(categoryId == null){
            return ResponseEntity.badRequest().build();
        }
        categoryService.DeleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}
