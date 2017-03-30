package com.process.PersonManager.service;

import com.process.PersonManager.dao.contentDao.PersonDao;
import com.process.PersonManager.model.contentModel.Person;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Кирилл on 11.02.2017.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest

public class PersonServiceTest {

    private static final Logger logger = Logger.getLogger(PersonServiceTest.class);

    @Autowired
    private PersonDao personDao;

   /* @Before
    public void setUp(){
        Person person1 = new Person("Kirill","Bulychev",new Date(1995,10,18));
        Person person2 = new Person("ASdasd","asdasd",new Date(1559,25,56));
        Person person3 = new Person("BBBBB","AAAA",new Date(2556,56,55));

        personDao.save(Arrays.asList(person1,person2,person3));
    }*/

    @Test
    public void testFindAllPersons(){
        logger.info("ALL PERSONS");
        List<Person> allPersons = (List<Person>) personDao.findAll();
        allPersons.forEach(s->logger.info("Info about person:"+s));
    }

    @Test
    public void testDeleteStudents(){
        personDao.delete(10);
        testFindAllPersons();
    }

    @Test
    public void testFindOne(){
        logger.info("FIND PERSON"+personDao.findOne(25));
    }

    @After
    public void clean(){
        personDao.deleteAll();
    }
}
