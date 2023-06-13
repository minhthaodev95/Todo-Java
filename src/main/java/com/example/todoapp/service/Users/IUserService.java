package com.example.todoapp.service.Users;

import java.util.List;

import com.example.todoapp.model.User;

public interface IUserService {

    // CRUD Operations
    public List<User> getAllUsers();
    public User getUserById(Long userId);
    public User createUser(User user);
    public User updateUser(Long userId, User user);
    public void deleteUser(Long userId);
}

