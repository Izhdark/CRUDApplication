package com.process.PersonManager.dao.contentDao;

import com.process.PersonManager.model.contentModel.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Кирилл on 12.02.2017.
 */
public interface BankDao extends JpaRepository<Bank,Integer> {
}
