package com.example.demo.repository;

import com.example.demo.domain.Contact;
import com.example.demo.domain.User;

import java.util.*;

public class ContactStorage {

    private static final Map<Long,Contact> CONTACTS = new HashMap<>();

    public static void clear() {
        CONTACTS.clear();
    }

    public static void addContact(Contact... contacts) {
        Arrays.stream(contacts).forEach(contact -> {
            CONTACTS.put(contact.getId(), contact);
        });
    }

    static Contact createContact(Contact contact) {
        CONTACTS.put(contact.getId(), contact);
        return contact;
    }

    public static int getSize() {
        return CONTACTS.size();
    }

    static List<Contact> getContactsByUserId(long userId) {
        List<Contact> list = new ArrayList<>();
        CONTACTS.forEach((key, value) -> {
            if (value.getUserId() == userId) {
                list.add(value);
            }
        });
        return list;
    }

    static Contact updateContact(long userId, Contact contact) {
        CONTACTS.put(contact.getId(), contact);
        return contact;
    }

    static void delete(long userId, long contactId) {
        CONTACTS.remove(contactId);
    }

    static Contact getContactsByName(String contactName) {
        Map<String, Contact> map = new HashMap<>();
        CONTACTS.forEach((key,value)->{
            if (value.getName().equals(contactName)) {
                map.put(contactName, value);
            }
        });
        return map.get(contactName);
    }
}
