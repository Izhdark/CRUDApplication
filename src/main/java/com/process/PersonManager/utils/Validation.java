package com.process.PersonManager.utils;

import com.process.PersonManager.model.loginForm.User;
import com.process.PersonManager.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class Validation implements Validator{

    private final UserService userService;

    @Autowired
    public Validation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if(userService.findByEmail(user.getEmail())!=null) {
            errors.rejectValue("Email", ErrorMessage.EMAIL_NOT_UNIQUE);
        }

    }
}
