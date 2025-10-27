package com.alencar.to_do_app.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.alencar.to_do_app.repository.taskRepository;
import com.alencar.to_do_app.model.Task;;

@SpringBootTest
@AutoConfigureMockMvc
public class controllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private taskRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();
        repository.save(new Task("Titulo teste", "Descrição teste"));
    }

    @Test
    void shouldReturnTaskById() throws Exception {
        Task task = repository.findAll().get(0);

        mockMvc.perform(get("/" + task.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("Titulo teste"));
    }
    
}
