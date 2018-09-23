package com.example.demo.repository;


import com.example.demo.domain.Contact;
import com.example.demo.domain.User;

import java.util.List;

public interface ContactRepository {
    Contact createContact(Contact contact);

    List<Contact> getContactsByUserId(long userId);

    Contact updateContact(long userId, Contact contact);

    void delete(long userId, long contactId);

    Contact getContactsByName(String contactName);
}
