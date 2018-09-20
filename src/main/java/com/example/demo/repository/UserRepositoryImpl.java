package com.example.demo.repository;


import com.example.demo.domain.Contact;
import com.example.demo.domain.User;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findUserById(long id) {
        return UserStorage.findUserById(id);
    }

    @Override
    public User addContactById(long id, Contact contact) {
        return UserStorage.addContactById(id, contact);
    }

    @Override
    public User updateContactByUserId(long id, Contact contact) {
        return UserStorage.updateContactByUserId(id, contact);
    }

    @Override
    public void deleteContactByUserId(long userId, long contactId) {
        UserStorage.deleteContactByUserId(userId, contactId);
    }
}
