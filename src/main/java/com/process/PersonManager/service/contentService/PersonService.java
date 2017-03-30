package com.process.PersonManager.service.contentService;

import com.process.PersonManager.model.contentModel.Bank;
import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.model.contentModel.Person;

import java.sql.Date;
import java.util.List;

/**
 * Created by Кирилл on 10.02.2017.
 */
public interface PersonService {
    List<Person> findAll();
    Person getPersonById(int id);
    void addPerson(Person person);
    void updatePerson(String firstName, String lastName, Date birthDate, int id);
    void deletePerson(int id);
    List<CreditCard> findCreditCardsByIdOfPerson(int id);
    Bank findBankByIdPerson(int id);
}
