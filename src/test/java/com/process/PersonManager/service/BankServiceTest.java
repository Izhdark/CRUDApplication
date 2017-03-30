package com.process.PersonManager.service;

import com.process.PersonManager.dao.contentDao.BankDao;
import com.process.PersonManager.model.contentModel.Bank;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.sql.Time;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Кирилл on 12.02.2017.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest
public class BankServiceTest {

    private static final Logger logger = Logger.getLogger(BankServiceTest.class);

    @Autowired
    private BankDao bankDao;

    private Validator validator;

    /*@Before
    public void setUp(){
        Bank bank1 = new Bank("ASD","site.com","asdasdasd",new Time(50));
        Bank bank2 = new Bank("LOL","wewewe.com","wwww",new Time(60));
        Bank bank3 = new Bank("JAJA","dwdwdw.com","dddd",new Time(70));

        bankDao.save(Arrays.asList(bank1,bank2,bank3));
    }*/

    @Test
    public void testValidationBank(){
        Bank bank = new Bank("asw","ssss.com","asda sadw sad",new Time(20,35,0));
        Set<ConstraintViolation<Bank>> constraintViolations = validator.validate(bank);
        assertEquals( 1, constraintViolations.size() );
    }

    @Test
    public void testFindAllBanks(){
        logger.info("ALL BANKS");
        List<Bank> allPersons = (List<Bank>) bankDao.findAll();
        allPersons.forEach(s->logger.info("****************************INFO"+s));
    }

    @Test
    public void testDeleteBankById(){
        bankDao.delete(25);
        testFindAllBanks();
    }
}
