package com.example.todo_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping
    public String getTasks() {
        return "Hello, this is the list of tasks!";
    }
}
