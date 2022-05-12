package com.example.todolist.controller;

import com.example.todolist.jwt.JwtTokenProvider;
import com.example.todolist.model.User;
import com.example.todolist.model.dto.request.UserRequestDto;
import com.example.todolist.model.dto.response.UserResponseDto;
import com.example.todolist.service.mapper.UserMapper;
import com.example.todolist.service.security.AuthenticationService;
import java.util.Map;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticateController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtProvider;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authenticationService.register(requestDto.getName(), requestDto.getPassword());
        return userMapper.mapToDto(user);
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authenticationService.login(requestDto.getName(), requestDto.getPassword());
        String token = jwtProvider.createToken(user.getName());
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
