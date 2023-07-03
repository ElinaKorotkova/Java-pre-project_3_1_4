package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserService {
    public void add(User user);

    public void update(User user);

    public void delete(Long id);

    List<User> getAllUsers();

    User show(Long id);

    User findByUsername(String firstName);
}
