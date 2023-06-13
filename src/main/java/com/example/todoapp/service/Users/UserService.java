package com.example.todoapp.service.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.model.User;
import com.example.todoapp.repository.UserRepository;

@Service
public class UserService implements IUserService {

    private static final Map<Long, User> usersMap = new HashMap<>();
    private static Long userId = 1L;

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public User getUserById(Long userId) {
        return usersMap.get(userId);
    }

    @Override
    public User createUser(User user) {
        user.setId(userId++);
        usersMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existingUser = usersMap.get(userId);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            // Add more properties as needed
            return existingUser;
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        usersMap.remove(userId);
    }
}

