package com.servme.todoapp.controller;

import com.servme.todoapp.auth.model.User;
import com.servme.todoapp.auth.service.SecurityService;
import com.servme.todoapp.auth.service.UserService;
import com.servme.todoapp.auth.validator.UserValidator;
import com.servme.todoapp.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @PostMapping(value = "/registration")
    public ResponseEntity<String> registerNewUser(@RequestBody User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        userService.save(user);

        return new ResponseEntity<String>("success", HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

}
