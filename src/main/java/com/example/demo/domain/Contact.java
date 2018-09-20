package com.example.demo.domain;

public class Contact {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(int id, String name, int age, String gender, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
