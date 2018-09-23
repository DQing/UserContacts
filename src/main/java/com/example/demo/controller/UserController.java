package com.example.demo.controller;

import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.ContactRepositoryImpl;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {


    private ContactRepository contactRepository = new ContactRepositoryImpl();

    @PostMapping("/users/{id}/contacts")
    ResponseEntity createContact(@PathVariable long id, @RequestBody Contact contact) {
        Contact result = contactRepository.createContact(contact);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}/contacts")
    List<Contact> getContacts(@PathVariable long userId) {
      return contactRepository.getContactsByUserId(userId);
    }

    @PutMapping("/users/{userId}/contacts")
    Contact updateContact(@PathVariable long userId, @RequestBody Contact contact) {
        return contactRepository.updateContact(userId, contact);
    }

    @DeleteMapping("/users/{userId}/contacts/{contactId}")
    ResponseEntity deleteContact(@PathVariable long userId, @PathVariable long contactId) {
        contactRepository.delete(userId, contactId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/contacts")
    Contact getUserContact(@RequestParam String userName, @RequestParam String contactName) {
        return contactRepository.getContactsByName(contactName);
    }
}
