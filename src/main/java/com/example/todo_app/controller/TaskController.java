package com.example.todo_app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.todo_app.entities.Task;
import com.example.todo_app.repository.TaskRepository;

import jakarta.transaction.Transactional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public String helloWorld() {
        return "Hello, this is the list of tasks!";
    }

    @ResponseBody
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        Date date = new Date();

        Task task = new Task("Tarefa 123", "Realizar tarefa", date);

        return Arrays.asList(task);
    }

    @ResponseBody
    @Transactional
    @PostMapping("/tasks")
    public void storeTask(@RequestBody Task task){
        this.taskRepository.save(task);
    }
}
