package com.process.PersonManager.controller.PersonControllers;

import com.process.PersonManager.model.contentModel.Bank;
import com.process.PersonManager.service.contentService.BankService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.Time;

/**
 * Created by Кирилл on 19.02.2017.
 */
@Controller
public class BankController {

    private static final Logger logger = Logger.getLogger(PersonController.class);

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping( value = "/main/tables/bank" )
    public String showBanks(Model model){
        logger.info("/main/tables/bank");
        logger.info(bankService.findAll());
        model.addAttribute("banks",bankService.findAll());
        return "tables/bank";
    }

    @RequestMapping(value = "/main/tables/bank/add")
    public String addBankForm(){
        return "/actions/addBank";
    }

    //@RequestParam("site") String site,@RequestParam("name") String name,@RequestParam("adress") String adress,@RequestParam("term_of_issue_of_bank_cards") String time

    @RequestMapping(value = "/main/tables/bank/addBank", method = RequestMethod.POST)
    public String addData(@Valid Bank bank, BindingResult result,@RequestParam("term_of_issue_of_bank_cards") String time){
        logger.info("/main/tables/bank/addBank");
        logger.info(bank);
        String[] data = time.split(":");
        Time localtime = new Time(Integer.parseInt(data[0]),Integer.parseInt(data[1]),0);
        bank.setTerm_of_issue_of_bank_cards(localtime);
        logger.info(bank);
        bankService.addBank(bank);
        return "redirect:/main/tables/bank";
    }

    @RequestMapping(value = "/main/tables/bank/cancel")
    public String cancel(){
        return "redirect:/main/tables/bank";
    }

    @RequestMapping(value = "/main/tables/bank/delete", method = RequestMethod.POST)
    public String deleteBank(@RequestParam("getIdBank") int id){
        logger.info("/main/tables/bank/delete");
        logger.info(id);
        bankService.deleteBank(id);
        return "redirect:/main/tables/bank";
    }

    @RequestMapping(value = "/main/tables/bank/edit")
    public String showBankToUpdate(@RequestParam("edit") int id, Model model){
        logger.info("/main/tables/bank/edit");
        logger.info(bankService.getBankById(id));
        model.addAttribute("bank",bankService.getBankById(id));
        return "/actions/editBank";
    }

    @RequestMapping(value = "/main/tables/bank/updateBank", method = RequestMethod.POST)
    public String updateData(@ModelAttribute("updateBank") Bank bank){
        logger.info("/main/tables/updateBank");
        logger.info(bank.getId());
        logger.info(bank.getTerm_of_issue_of_bank_cards());
        logger.info(bank);
        bankService.addBank(bank);
        return "redirect:/main/tables/bank";
    }


}
