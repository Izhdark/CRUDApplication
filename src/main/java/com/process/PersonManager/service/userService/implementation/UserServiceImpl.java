package com.process.PersonManager.service.userService.implementation;

import com.process.PersonManager.dao.registration.UserDao;
import com.process.PersonManager.model.loginForm.User;
import com.process.PersonManager.model.loginForm.UserRole;
import com.process.PersonManager.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Кирилл on 28.02.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByid(int id) {
        return userDao.findOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void Save(User user,String token) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreation_date(new Date());
        user.setUserRole(UserRole.User.name());
        user.setToken(token);
        userDao.save(user);
    }

    @Override
    public User createNewUserAccount(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreation_date(new Date());
        user.setUserRole(UserRole.User.name());
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void saveWithToken(User user, String token) {
    }

    @Override
    public User findByToken(String token) {
        return userDao.findByToken(token);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }
}
