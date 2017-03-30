package com.process.PersonManager.service;

import com.process.PersonManager.model.contentModel.Bank;
import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.model.contentModel.Person;
import com.process.PersonManager.model.contentModel.Purchase;
import com.process.PersonManager.service.contentService.CreditCardService;
import com.process.PersonManager.service.contentService.PersonService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

/**
 * Created by Кирилл on 12.02.2017.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest
public class CreditCardServiceTest {
    private static final Logger logger = Logger.getLogger(CreditCardServiceTest.class);


    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private PersonService personService;

    /*  @Before
      public void setUp(){
          Person person1 = new Person("Kirill","Bulychev",new Date(1995,10,18));
          Bank bank1 = new Bank("ASD","site.com","asdasdasd",new Time(50));
          CreditCard first = new CreditCard("visa","2515-5647-8582-5625",person1,250,bank1);
          CreditCard second = new CreditCard("MasterCard","7854-5689-2145-5625",person1,777,bank1);
          personDao.save(person1);
          bankDao.save(bank1);
          creditCardDao.save(Arrays.asList(first,second));
      }
  */
    @Test
    public void testFindAllCreditCards() {
        logger.info("ALL CARDS");
        List<CreditCard> allCards = (List<CreditCard>) creditCardService.findAll();
        allCards.forEach(s -> logger.info("****************************INFO" + s + "IDPESRON:" + s.getPrimaryPerson().getId() + "IDBANK" + s.getPrimaryBank().getId()));
        logger.info("*****************INFOPERSON" + personService.findAll());
    }

    @Test
    public void testFindAllPersons() {
        logger.info("ALL Persons");
        List<Person> allPersons = (List<Person>) personService.findAll();
        allPersons.forEach(s -> logger.info("****************************INFO" + s));
    }

    @Test
    public void findPersonByNumberOfCard() {
        logger.info("Person");
        Person person = creditCardService.findPersonByNumberOfCreditCard("7777-8888-2222-3333");
        logger.info("*****************INFOBANK" + person);
    }

    @Test
    public void findCreditCardsByIdOfPerson() {
        List<CreditCard> creditCards = personService.findCreditCardsByIdOfPerson(66);
        creditCards.forEach(s -> logger.info("****************************INFO" + s));
    }

    @Test
    public void findPurchasesByIdCard() {
        List<Purchase> Purchase = creditCardService.findPurchasesByIdCard("7777-8888-2222-3333");
        Purchase.forEach(s -> logger.info("****************************INFO" + s));
    }

    @Test
    public void testFindBankByIdPerson(){
        Bank bank = personService.findBankByIdPerson(66);
        logger.info("*****************INFOBANK" + bank);
    }

    @Test
    public void testUpdatePerson(){
        logger.info("Person");
        personService.updatePerson("ASDWE","SADWE",new Date(1995-05-11),71);
        logger.info(personService.getPersonById(71));
    }
}
