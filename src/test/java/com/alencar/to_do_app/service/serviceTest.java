package com.alencar.to_do_app.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

import com.alencar.to_do_app.model.Task;
import com.alencar.to_do_app.repository.taskRepository;
import com.alencar.to_do_app.services.taskService;

@SpringBootTest
public class serviceTest {
    
    @Mock private taskRepository repository;
    @InjectMocks private taskService service;

    @Test
    void shouldReturnTaskById() throws Exception {
        Task mockTask = new Task("Titulo teste", "descrição teste");
        
        when(repository.findById(1L)).thenReturn(Optional.of(mockTask));

        Task task = repository.findById(1L).orElse(null);

        assertEquals("Titulo teste", task.getTitle());
        verify(repository).findById(1L);

    }
}
