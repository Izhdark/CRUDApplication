package com.process.PersonManager.dao.contentDao;

import com.process.PersonManager.model.contentModel.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Кирилл on 14.02.2017.
 */
public interface PurchaseDao extends JpaRepository<Purchase,Integer> {

}
