package com.example.todo_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication {

  private static Logger log = LoggerFactory.getLogger(TodoAppApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(TodoAppApplication.class, args);
  }
}
