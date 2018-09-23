package com.example.demo.domain;

public class Contact {
    private long id;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    private long userId;

    public Contact() {
    }

    public Contact(long id, String name, int age, String gender, String phoneNumber, long userId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getUserId() {
        return userId;
    }
}
