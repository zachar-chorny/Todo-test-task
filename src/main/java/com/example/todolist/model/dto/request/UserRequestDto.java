package com.example.todolist.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Password cannot be null")
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String password;
}
