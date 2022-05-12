package com.example.todolist.service.mapper;

import com.example.todolist.model.User;
import com.example.todolist.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        return responseDto;
    }

}
