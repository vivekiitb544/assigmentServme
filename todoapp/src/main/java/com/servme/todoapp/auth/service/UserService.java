package com.servme.todoapp.auth.service;


import com.servme.todoapp.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
