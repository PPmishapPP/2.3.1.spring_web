package ru.mishapp.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mishapp.springapp.dao.UserDao;
import ru.mishapp.springapp.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        if (user.getId() == null){
            userDao.addUser(user);
        } else {
            userDao.updateUser(user);
        }
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
}
