package com.process.PersonManager.dao.contentDao;

import com.process.PersonManager.model.contentModel.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

/**
 * Created by Кирилл on 10.02.2017.
 */
public interface PersonDao extends JpaRepository<Person,Integer>{

    @Modifying
    @Query("update Person p set p.firstName=?1, p.lastName=?2, p.birthDate=?3 where p.id=?4")
    void updatePerson(String firstName, String lastName, Date birthDate, int id);
}
