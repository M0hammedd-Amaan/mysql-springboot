package com.example.springboot_mysql_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 1. Insert User (POST)
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 2. Delete User by ID (DELETE)
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User with ID " + id + " has been deleted.";
    }

    // 3. Get All Users (GET)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
