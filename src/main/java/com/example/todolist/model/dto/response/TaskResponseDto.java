package com.example.todolist.model.dto.response;

import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private String text;
    private boolean isComplete;
}
