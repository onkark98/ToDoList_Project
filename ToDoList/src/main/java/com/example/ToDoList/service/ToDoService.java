package com.example.ToDoList.service;

import com.example.ToDoList.model.ToDo;

import java.util.List;

public interface ToDoService {

    ToDo saveToDo(ToDo toDo);

    List<ToDo> getAllToDo();

    ToDo updateToDo(ToDo toDo, long id);

    void deleteToDo(long id);

    String deleteAll();
}
