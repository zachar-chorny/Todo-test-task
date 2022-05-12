package com.example.todolist.service.impl;

import com.example.todolist.dao.TaskDao;
import com.example.todolist.model.Task;
import com.example.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;

    @Override
    public Task create(Task task) {
        return taskDao.save(task);
    }

    @Override
    public Task get(Long id) {
        return taskDao.getById(id);
    }

    @Override
    public Task update(Task task) {
        return taskDao.save(task);
    }

    @Override
    public void delete(Long id) {
        taskDao.deleteById(id);
    }
}
