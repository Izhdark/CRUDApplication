package com.process.PersonManager.service.contentService.Impl;

import com.process.PersonManager.dao.contentDao.PersonDao;
import com.process.PersonManager.model.contentModel.Bank;
import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.model.contentModel.Person;
import com.process.PersonManager.service.contentService.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

/**
 * Created by Кирилл on 10.02.2017.
 */
@Service
@Transactional
public class PersonServiceImpl  implements PersonService{

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> findAll() {
        return (List<Person>) personDao.findAll();
    }

    @Override
    public Person getPersonById(int id) {
        return personDao.findOne(id);
    }

    @Override
    public void addPerson(Person person) {
        personDao.save(person);
    }

    @Override
    public void updatePerson(String firstName, String lastName, Date birthDate, int id) {
        personDao.updatePerson(firstName,lastName,birthDate,id);
    }

    @Override
    public void deletePerson(int id) {
        personDao.delete(id);
    }

    @Override
    public List<CreditCard> findCreditCardsByIdOfPerson(int id) {
        return personDao.findOne(id).getPersonList();
    }

    @Override
    public Bank findBankByIdPerson(int id) {
        if(!personDao.findOne(id).getPersonList().isEmpty()){
            return personDao.findOne(id).getPersonList().get(0).getPrimaryBank();
        }
        return null;
    }
}
