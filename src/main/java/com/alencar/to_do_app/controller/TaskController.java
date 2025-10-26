package com.alencar.to_do_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alencar.to_do_app.services.taskService;
import com.alencar.to_do_app.model.Task;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
public class TaskController {

    @Autowired
    private taskService service;

    @PostMapping
    public Task AddTask(@RequestBody Task newTask) {
        return service.createTask(newTask);
    }

    @GetMapping
    public List<Task> getAllTask() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> setTaskCompleted(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.setCompleted(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
