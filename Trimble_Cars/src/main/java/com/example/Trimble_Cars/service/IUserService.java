package com.example.Trimble_Cars.service;

import com.example.Trimble_Cars.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
     List<User> getAllUsers();
     Optional<User> getUserById(Long id);
     User addUser(User user);
}
