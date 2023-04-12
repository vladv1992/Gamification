package com.webapplication.service;

import com.webapplication.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(Long id, User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void delete(User user);
}
