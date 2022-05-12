package com.example.todolist.service.security;

import com.example.todolist.model.User;
import com.example.todolist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name).orElseThrow(
                () -> new RuntimeException("Can't find user by name: " + name));
        UserBuilder userBuilder = org.springframework.security.core.userdetails
                .User.withUsername(name);
        userBuilder.password(user.getPassword());
        userBuilder.roles("User");
        return userBuilder.build();
    }
}
