package com.webapplication.service;

import com.webapplication.model.Ranking;
import com.webapplication.model.User;
import com.webapplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    OperationService operationService;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        final Optional<User> userById = Optional.of(userRepository.findById(id).orElse(new User(0, "",
                "", "", new Ranking(0), "", 0,
                false)));
        userById.ifPresent(u -> {
            u.setUserId(user.getUserId());
            u.setUserAnswer();
        });
        return userById.orElse(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

}
