package com.example.demo.repository;


import com.example.demo.domain.Contact;
import com.example.demo.domain.User;

import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    @Override
    public Contact createContact(Contact contact) {
        return ContactStorage.createContact(contact);
    }

    @Override
    public List<Contact> getContactsByUserId(long userId) {
        return ContactStorage.getContactsByUserId(userId);
    }

    @Override
    public Contact updateContact(long userId, Contact contact) {
        return ContactStorage.updateContact(userId, contact);
    }

    @Override
    public void delete(long userId, long contactId) {
        ContactStorage.delete(userId, contactId);
    }

    @Override
    public Contact getContactsByName(String contactName) {
        return ContactStorage.getContactsByName(contactName);
    }
}
