package com.process.PersonManager.service.userService;

/**
 * Created by Кирилл on 05.03.2017.
 */
public interface SecurityService {
    String findLoggedInEmail();
    void authenticateUser(String email,String password);
}
