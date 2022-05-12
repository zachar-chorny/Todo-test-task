package com.example.todolist.dao;

import com.example.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findUserByName(String name);
}
