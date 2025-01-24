package com.example.todo_app.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.todo_app.TodoAppApplication;
import com.example.todo_app.controller.DTO.TaskDTO;
import com.example.todo_app.controller.DTO.TaskFormDTO;
import com.example.todo_app.entities.Task;
import com.example.todo_app.repository.TaskRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tasks")
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
    public ResponseEntity<TaskDTO> storeTask(@RequestBody @Valid TaskFormDTO taskDTO) {
        Task task = taskDTO.convert();
        this.taskRepository.save(task);

         URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(task.getId())
            .toUri();
        
        return ResponseEntity.created(location).body(new TaskDTO(task));
    }

    @GetMapping("{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        Task task = this.taskRepository.findById(id).orElseThrow();
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
    public Task deleteTask(@PathVariable Long id) {
        Task task = this.taskRepository.findById(id).orElseThrow();
        this.taskRepository.deleteById(id);
        return task;
    }
}
