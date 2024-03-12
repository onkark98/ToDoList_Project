package com.example.ToDoList.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "todolist")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "task")
    private String task;
    @Column(name = "completed")
    private boolean completed;

    public ToDo() {
    }

    public ToDo(long id, String task, boolean completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }



}
