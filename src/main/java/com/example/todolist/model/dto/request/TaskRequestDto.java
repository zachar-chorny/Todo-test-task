package com.example.todolist.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDto {
    @NotNull(message = "Text cannot be null")
    @NotEmpty(message = "Text cannot be empty")
    private String text;
    @JsonProperty
    private boolean isComplete;

}
