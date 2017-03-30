package com.process.PersonManager.service.userService.implementation;

import com.process.PersonManager.dao.registration.UserDao;
import com.process.PersonManager.model.loginForm.User;
import com.process.PersonManager.model.loginForm.UserRole;
import com.process.PersonManager.utils.ErrorMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email){
        User user =  userDao.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException(ErrorMessage.EMAIL_NOT_FOUND + email);
        }
        logger.info(user);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole()));

        logger.info(grantedAuthorities);

        return new org.springframework.security.core.userdetails.User
                (user.getEmail(),user.getPassword(),grantedAuthorities);
    }
}
