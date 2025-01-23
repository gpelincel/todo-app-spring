package com.example.todo_app.controller.DTO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.todo_app.entities.Task;

public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Date taskDate;
    private Boolean isDone;
    
    public TaskDTO(Task task){
        id = getId();
        title = getTitle();
        description = getDescription();
        taskDate = getTaskDate();
        isDone = getIsDone();
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
