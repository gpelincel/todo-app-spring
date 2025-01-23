package com.example.todo_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_app.controller.DTO.TaskDTO;
import com.example.todo_app.controller.DTO.TaskFormDTO;
import com.example.todo_app.entities.Task;
import com.example.todo_app.repository.TaskRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/tasks/")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<TaskDTO> getTasks() {
        List<Task> tasks = this.taskRepository.findAll();
        return TaskDTO.convert(tasks);
    }

    @PostMapping
    @Transactional
    public TaskDTO storeTask(@RequestBody TaskFormDTO taskDTO) {
        Task task = taskDTO.convert();
        this.taskRepository.save(task);
        return new TaskDTO(task);
    }

    @GetMapping("{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        Task task = this.taskRepository.findById(id).orElse(null);
        return new TaskDTO(task);
    }

    @Transactional
    @PutMapping("{id}")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody TaskFormDTO updatedTask) {
        Task task = this.taskRepository.findById(id).orElseThrow();

        updatedTask.TaskUpdate(task);
        this.taskRepository.save(task);

        return new TaskDTO(task);
    }

    @Transactional
    @DeleteMapping("{id}")
    public String deleteTask(@PathVariable Long id) {
        this.taskRepository.deleteById(id);
        return "Task deleted";
    }
}
