package com.webapplication.controller;

import com.webapplication.service.ResourceNotFoundExeption;
import com.webapplication.model.User;
import com.webapplication.service.OperationService;
import com.webapplication.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private OperationService service;

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userServiceImplementation.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundExeption {
        User user = userServiceImplementation.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userServiceImplementation.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @RequestBody User userDetails) {
        User user = userServiceImplementation.updateUser(userId, userDetails);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userServiceImplementation.getUserById(userId);

        userServiceImplementation.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
