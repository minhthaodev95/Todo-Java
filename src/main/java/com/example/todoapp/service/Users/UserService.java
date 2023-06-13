package com.example.todoapp.service.Users;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.todoapp.model.User;
import com.example.todoapp.repository.UserRepository;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            userRepository.save(existingUser);
            
            return existingUser;
        }
        return null;
    }

   @Override
   public ResponseEntity<?> deleteUser(Long userId) {
    User existingUser = userRepository.findById(userId).orElse(null);
    if (existingUser != null) {
       userRepository.deleteById(userId);
       return ResponseEntity.ok("User Deleted Successfully");
    }
    return ResponseEntity.ok("User Not Found");
   }
   
}

