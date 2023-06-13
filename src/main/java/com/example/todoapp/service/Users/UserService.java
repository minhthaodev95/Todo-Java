package com.example.todoapp.service.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.model.User;
import com.example.todoapp.repository.UserRepository;

@Service
public class UserService implements IUserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
