package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.example.demo.repository.ContactStorage;
import com.example.demo.repository.UserStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class UserControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = standaloneSetup(UserController.class).build();
        UserStorage.clear();
        ContactStorage.clear();
    }

    private void setupData() {
        Contact contact1 = new Contact(1, "zhang san", 18, "male", "15829342367",1);
        Contact contact2 = new Contact(2, "xiao hong", 28, "female", "13329342367",2);
        ContactStorage.addContact(contact1, contact2);
        User user1 = new User(1,"dou qingqing");
        User user2 = new User(2,"huang lizheng");
        UserStorage.addUser(user1, user2);
    }

    @Test
    void should_create_contact_for_user() throws Exception {
        setupData();
        Contact contact = new Contact(3, "wang wu", 28, "female", "12829342367",1);
        int originalSize  =  ContactStorage.getSize();
        mockMvc.perform(post("/api/users/5/contacts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(jsonPath("$.id").value("3"))
                .andExpect(jsonPath("$.name").value("wang wu"))
                .andExpect(jsonPath("$.age").value(28))
                .andExpect(status().isCreated());
        assertEquals(originalSize + 1, ContactStorage.getSize());
    }

    @Test
    void should_get_user_contacts() throws Exception {
        setupData();
        mockMvc.perform(get("/api/users/1/contacts"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("zhang san"))
                .andExpect(jsonPath("$[0].age").value(18))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].phoneNumber").value("15829342367"))
                .andExpect(status().isOk());
    }

    @Test
    void should_update_user_contacts() throws Exception{
        setupData();
        Contact contact = new Contact(1, "zhang san", 20, "female", "15829342367",1);
        mockMvc.perform(put("/api/users/1/contacts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("zhang san"))
                .andExpect(jsonPath("$.age").value(20))
                .andExpect(jsonPath("$.gender").value("female"))
                .andExpect(status().isOk());
    }

    @Test
    void should_delete_user_contact() throws Exception{
        setupData();
        int originalSize = ContactStorage.getSize();
        mockMvc.perform(delete("/api/users/1/contacts/1"))
                .andExpect(status().isNoContent());
        assertEquals(originalSize - 1, ContactStorage.getSize());
    }

    @Test
    void should_get_user_contact() throws Exception {
        setupData();
        mockMvc.perform(get("/api/users/contacts")
                .param("userName", "dou qingqing")
                .param("contactName", "xiao hong"))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("xiao hong"))
                .andExpect(jsonPath("$.age").value("28"))
                .andExpect(jsonPath("$.gender").value("female"))
                .andExpect(status().isOk());
    }
}
