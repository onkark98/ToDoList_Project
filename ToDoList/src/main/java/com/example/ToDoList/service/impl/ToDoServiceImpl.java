package com.example.ToDoList.service.impl;

import com.example.ToDoList.exception.ResourceNotFoundException;
import com.example.ToDoList.model.ToDo;
import com.example.ToDoList.repository.ToDoRepository;
import com.example.ToDoList.service.ToDoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public ToDo saveToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo updateToDo(ToDo toDo, long id) {
        ToDo existingToDo = toDoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task", "id", id));

        existingToDo.setTask(toDo.getTask());
        existingToDo.setCompleted(toDo.isCompleted());

        return existingToDo;
    }

    @Override
    public void deleteToDo(long id) {
        toDoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task", "id", id));

        toDoRepository.deleteById(id);
    }

    @Override
    public String deleteAll() {
        if (toDoRepository.count() == 0)
        {
            return "No tasks to do delete";
        }
        toDoRepository.deleteAll();
        return "All tasks deleted";
    }

}
