package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.User;
import com.example.todoapp.service.Users.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
  
}
