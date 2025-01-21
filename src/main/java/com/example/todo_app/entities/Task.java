package com.example.todo_app.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date taskDate;
    

    public Task(String title, String description, Date taskDate) {
        this.title = title;
        this.description = description;
        this.taskDate = taskDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getTaskDate() {
        return taskDate;
    }
    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    
}
