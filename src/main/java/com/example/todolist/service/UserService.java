package com.example.todolist.service;

import com.example.todolist.model.User;
import java.util.Optional;

public interface UserService {

    User add(User user);

    User get(Long id);

    Optional<User> findByName(String name);
}
