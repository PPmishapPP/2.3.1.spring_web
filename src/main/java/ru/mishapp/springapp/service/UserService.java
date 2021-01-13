package ru.mishapp.springapp.service;

import ru.mishapp.springapp.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    List<User> getAllUsers();
}
