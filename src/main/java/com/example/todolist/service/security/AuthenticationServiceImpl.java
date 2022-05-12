package com.example.todolist.service.security;

import com.example.todolist.exception.AuthenticationException;
import com.example.todolist.exception.NameAlreadyExistException;
import com.example.todolist.exception.UserNotFoundException;
import com.example.todolist.model.User;
import com.example.todolist.service.UserService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    @Override
    public User register(String name, String password) {
        if (userService.findByName(name).isEmpty()) {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            return userService.add(user);
        }
        throw new NameAlreadyExistException("User with this name already exist");
    }

    @Override
    public User login(String name, String password) {
        Optional<User> user = userService.findByName(name);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User with this name does not exist");
        } else if (!user.get().getPassword().equals(password)) {
            throw new AuthenticationException("Incorrect password");
        }
        return user.get();
    }
}
