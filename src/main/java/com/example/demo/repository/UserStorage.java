package com.example.demo.repository;

import com.example.demo.domain.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static final Map<Long, User> USERS = new HashMap<>();

    public static void clear() {
        USERS.clear();
    }

    public static void addUser(User... user) {
        Arrays.stream(user).forEach(person -> {
            USERS.put(person.getId(), person);
        });
    }
}
