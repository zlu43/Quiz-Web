package com.example.springmvctemplate.service;

import com.example.springmvctemplate.dao.UserDao;
import com.example.springmvctemplate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void activateOrSuspendUser(int user_id, String action) {
        userDao.activateOrSuspendUserById(user_id, action);
    }
}
