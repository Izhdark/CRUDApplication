package com.process.PersonManager.dao.contentDao;

import com.process.PersonManager.model.contentModel.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Кирилл on 12.02.2017.
 */
public interface CreditCardDao extends JpaRepository<CreditCard,Integer> {

    @Query("select u from CreditCard u where u.number=:number")
    CreditCard findByNumber(@Param("number") String number);
}
