package com.process.PersonManager.dao.registration;

import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.model.loginForm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Кирилл on 28.02.2017.
 */
public interface UserDao extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.email=:email")
    User findByEmail(@Param("email") String email);

    User findByToken(String token);
}
