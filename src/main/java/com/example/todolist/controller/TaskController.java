package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.model.dto.request.TaskRequestDto;
import com.example.todolist.model.dto.response.TaskResponseDto;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.mapper.TaskMapper;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("{id}")
    public TaskResponseDto getTask(@PathVariable Long id) {
        return taskMapper.mapToDto(taskService.get(id));
    }

    @PostMapping("/create")
    public TaskResponseDto createTask(@RequestBody @Valid TaskRequestDto taskRequestDto) {
        return taskMapper.mapToDto(taskService.create(taskMapper.mapToModel(taskRequestDto)));
    }

    @PutMapping("/update/{id}")
    public TaskResponseDto updateTask(@PathVariable Long id,
                                      @RequestBody @Valid TaskRequestDto taskRequestDto) {
        Task task = taskMapper.mapToModel(taskRequestDto);
        task.setId(id);
        return taskMapper.mapToDto(taskService.update(task));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
