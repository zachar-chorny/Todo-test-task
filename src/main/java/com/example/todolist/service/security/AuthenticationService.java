package com.example.todolist.service.security;

import com.example.todolist.model.User;

public interface AuthenticationService {

    User register(String email, String password);

    User login(String login, String password);
}
