package com.example.demo.repository;


import com.example.demo.domain.Contact;
import com.example.demo.domain.User;

public interface UserRepository {
    User findUserById(long id);

    User addContactById(long id, Contact contact);
}
