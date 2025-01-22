package com.example.todo_app.controller.DTO;

import java.util.Date;

import com.example.todo_app.entities.Task;

public class TaskFormDTO {
    private Long id;
    private String title;
    private String description;
    private Date taskDate;

    public TaskFormDTO(String title, String description, Date taskDate) {
        this.title = title;
        this.description = description;
        this.taskDate = taskDate;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public Task convert() {
        Task task = new Task();
        
        task.setId(this.id);
        task.setTitle(this.title);
        task.setDescription(this.description);
        task.setTaskDate(this.taskDate);

        return task;
    }
}
