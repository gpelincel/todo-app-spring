package com.example.todo_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo_app.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
