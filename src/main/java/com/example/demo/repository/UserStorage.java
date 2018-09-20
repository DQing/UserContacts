package com.example.demo.repository;

import com.example.demo.domain.Contact;
import com.example.demo.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static final Map<Long, User> USERS = new HashMap<>();

    static {
        Contact contact = new Contact(1, "zhang san", 18, "male", "15829342367");
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(contact);
        USERS.put(1L, new User(1,"xiao wang", contacts));
    }

    public static User findUserById(long id) {
        return USERS.get(id);
    }

    static User addContactById(long id, Contact contact) {
         USERS.get(id).getContacts().add(contact);
        return USERS.get(id);
    }

    public static void clear() {
        USERS.clear();
    }

    public static void addUser(User... user) {
        Arrays.stream(user).forEach(person -> {
            USERS.put(person.getId(), person);
        });
    }

    public static User updateContactByUserId(long id, Contact contact) {
         USERS.get(id).getContacts().forEach(item -> {
             item.setId(contact.getId());
             item.setAge(contact.getAge());
             item.setGender(contact.getGender());
             item.setName(contact.getName());
             item.setPhoneNumber(contact.getPhoneNumber());
         });
        return USERS.get(id);
    }
}
