package com.servme.todoapp.services;

import com.servme.todoapp.model.Category;
import com.servme.todoapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //TODO: Need to have proper management of category with respect to users. One users should not be able to delete category created by other users
    //TODO: category should be mapped with other user

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public void DeleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
