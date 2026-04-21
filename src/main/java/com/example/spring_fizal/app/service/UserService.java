package com.example.spring_fizal.app.service;

import com.example.spring_fizal.app.exceptions.UserNotFoundException;
import com.example.spring_fizal.app.model.User;
import com.example.spring_fizal.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        logger.info("Creating user...");
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User existing = userRepository.findById(user.getId())
                .orElseThrow(() ->
                        new UserNotFoundException("User id " + user.getId() + " does not exist"));

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());

        return userRepository.save(existing);
    }

    public boolean deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User id " + id + " does not exist");
        }
        userRepository.deleteById(id);
        return true;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found");
        }

        return users;
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User id " + id + " does not exist"));
    }

    public List<User> searchUser(String name, String email) {
        return userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name, email);
    }
}