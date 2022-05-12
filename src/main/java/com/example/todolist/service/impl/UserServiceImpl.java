package com.example.todolist.service.impl;

import com.example.todolist.dao.UserDao;
import com.example.todolist.model.User;
import com.example.todolist.service.UserService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public User add(User user) {
        return userDao.save(user);
    }

    @Override
    public User get(Long id) {
        return userDao.getById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return Optional.ofNullable(userDao.findUserByName(name));
    }

}
