package com.demo.service;

import com.demo.model.Color;
import com.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersByAgeGreaterThan(int age);
    List<User> findAll();
    User getUserById(int id);
    void saveUser(User user);
    List<User> getUsersByColor(Color color);
    List<String> uniqUsersWith3Art();
}
