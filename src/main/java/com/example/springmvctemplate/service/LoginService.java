package com.example.springmvctemplate.service;

import com.example.springmvctemplate.dao.UserDao;
import com.example.springmvctemplate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    private UserDao userDao;

    @Autowired
    public LoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User validateLogin(String username, String password) {
        return userDao.validateLogin(username, password);
    }

    public void register(String username, String password,
                         String firstname, String lastname,
                         String phone, String email, String address) {
        userDao.register(username, password, firstname, lastname, phone, email, address);
    }


}
