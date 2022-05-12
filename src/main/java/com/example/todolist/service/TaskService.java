package com.example.todolist.service;

import com.example.todolist.model.Task;

public interface TaskService {

    Task create(Task task);

    Task get(Long id);

    Task update(Task task);

    void delete(Long id);
}
