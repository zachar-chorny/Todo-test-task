package com.example.todolist.service.mapper;

import com.example.todolist.model.Task;
import com.example.todolist.model.dto.request.TaskRequestDto;
import com.example.todolist.model.dto.response.TaskResponseDto;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {

    public TaskResponseDto mapToDto(Task task) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setId(task.getId());
        taskResponseDto.setText(task.getText());
        taskResponseDto.setComplete(task.isComplete());
        return taskResponseDto;
    }

    public Task mapToModel(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setText(taskRequestDto.getText());
        task.setComplete(taskRequestDto.isComplete());
        return task;
    }
}
