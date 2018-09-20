package com.example.demo.controller;

import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository = new UserRepositoryImpl();

    @PostMapping("/users/{id}/contacts")
    ResponseEntity createContactForUser(@PathVariable long id, @RequestBody Contact contact) {
        User user = userRepository.addContactById(id, contact);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}/contacts")
    User getUserContact(@PathVariable long id) {
        return userRepository.findUserById(id);
    }

    @PutMapping("/users/{id}/contacts")
    User updateUserContact(@PathVariable long id, @RequestBody Contact contact) {
        return userRepository.updateContactByUserId(id, contact);
    }
}
