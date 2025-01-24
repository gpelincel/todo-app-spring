package com.example.todo_app.controller.DTO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.todo_app.entities.Task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskDTO {
    private Long id;
    @NotBlank(message = "Task title cannot be null or empty")
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Date taskDate;
    private Boolean isDone;
    
    public TaskDTO(Task task){
        id = task.getId();
        title = task.getTitle();
        description = task.getDescription();
        taskDate = task.getTaskDate();
        isDone = task.getIsDone();
    }
    
    public Boolean getIsDone() {
        return isDone;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public static List<TaskDTO> convert(List<Task> tasks){
        return tasks.stream().map(TaskDTO::new).collect(Collectors.toList());
    }
}
