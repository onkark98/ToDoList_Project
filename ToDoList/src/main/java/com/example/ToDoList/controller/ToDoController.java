package com.example.ToDoList.controller;

import com.example.ToDoList.model.ToDo;
import com.example.ToDoList.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolist")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    //Creating a Task REST API
    @PostMapping
    public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo toDo)
    {
        return new ResponseEntity<ToDo>(toDoService.saveToDo(toDo), HttpStatus.CREATED);
    }

    //Getting all the tasks REST API
    @GetMapping
    public List<ToDo> getAllToDo()
    {
        return toDoService.getAllToDo();
    }

    //Update the task by id REST API
    @PutMapping("{id}")
    public ResponseEntity<ToDo> updateToDoById(@RequestBody ToDo toDo, @PathVariable("id") long id)
    {
        return new ResponseEntity<ToDo>(toDoService.updateToDo(toDo, id), HttpStatus.OK);
    }

    //Delete the task by id REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") long id)
    {
        toDoService.deleteToDo(id);
        return new ResponseEntity<String>("Task is deleted",HttpStatus.OK);
    }

    //Delete all the tasks
    @DeleteMapping
    public ResponseEntity<String> deleteAll()
    {
        return new ResponseEntity<String>(toDoService.deleteAll(),HttpStatus.OK);
    }


}
