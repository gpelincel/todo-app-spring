package com.example.todo_app.controller.DTO;

import java.util.Date;

import com.example.todo_app.entities.Task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskFormDTO {
    private Long id;
    @NotBlank(message = "Task title cannot be null or empty")
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Date taskDate;
    private Boolean isDone;

    public TaskFormDTO(String title, String description, Date taskDate, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.taskDate = taskDate;
        this.isDone = isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
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
        task.setIsDone(this.isDone);

        return task;
    }

    public void TaskUpdate(Task task){
        task.setDescription(description);
        task.setTitle(title);
        task.setTaskDate(taskDate);
        task.setIsDone(isDone);
    }

    @Override
    public String toString() {
        return "TaskFormDTO [id=" + id + ", title=" + title + ", description=" + description + ", taskDate=" + taskDate
                + ", isDone=" + isDone + "]";
    }
}
