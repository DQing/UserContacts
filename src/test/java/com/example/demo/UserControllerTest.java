package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.example.demo.repository.UserStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class UserControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = standaloneSetup(UserController.class).build();
        UserStorage.clear();
    }

    private void setupData() {
        Contact contact = new Contact(1, "zhang san", 18, "male", "15829342367");
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(contact);
        User user = new User(1,"dou qingqing", contacts);
        UserStorage.addUser(user);
    }

    @Test
    void should_create_contact_for_user() throws Exception {
        setupData();
        Contact contact = new Contact(2, "wang wu", 28, "female", "12829342367");
        mockMvc.perform(post("/api/users/1/contacts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.contacts",hasSize(2)))
                .andExpect(status().isCreated());
        assertEquals(2,UserStorage.findUserById(1).getContacts().size());
    }
}
