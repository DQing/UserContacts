package com.example.demo.domain;

import java.util.ArrayList;

public class User {
    private long id;
    private String name;
    private ArrayList<Contact> contacts;

    public User() {
    }

    public User(long id, String name, ArrayList<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

}
