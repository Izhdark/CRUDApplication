package com.process.PersonManager.service.userService;

import com.process.PersonManager.model.loginForm.User;

import java.util.List;

/**
 * Created by Кирилл on 28.02.2017.
 */
public interface UserService {
    User findUserByid(int id);
    User findByEmail(String Email);
    void Save(User user,String token);
    User createNewUserAccount(User user);
    List<User> findAllUsers();
    void saveWithToken(User user,String token);
    User findByToken(String token);
    void deleteUser(User user);
}
