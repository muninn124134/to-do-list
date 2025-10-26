package com.alencar.to_do_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alencar.to_do_app.model.Task;


@Repository
public interface taskRepository extends JpaRepository<Task, Long> {
    List<Task> findByisDone(boolean isDone);
    List<Task> findByTitle(String title);
    List<Task> findByDescription(String description);
}
