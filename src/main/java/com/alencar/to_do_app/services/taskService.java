package com.alencar.to_do_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alencar.to_do_app.repository.taskRepository;

import com.alencar.to_do_app.model.Task;

@Service
public class taskService {

    @Autowired
    private taskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Task getTaskById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task createTask(Task newTask) {
        return repository.save(newTask);
    }

    public Task setCompleted(Long id){
        return repository.findById(id)
            .map(task -> {
                task.setIsDone(true);
                return repository.save(task);
            })
            .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
