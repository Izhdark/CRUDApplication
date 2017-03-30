package com.process.PersonManager.controller.PersonControllers;

import com.process.PersonManager.model.contentModel.CreditCard;
import com.process.PersonManager.service.contentService.BankService;
import com.process.PersonManager.service.contentService.CreditCardService;
import com.process.PersonManager.service.contentService.PersonService;
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

/**
 * Created by Кирилл on 19.02.2017.
 */
@Controller
public class CreditCardController {

    private static final Logger logger = Logger.getLogger(PersonController.class);

    private final PersonService personService;

    private final CreditCardService creditCardService;

    private final BankService bankService;

    @Autowired
    public CreditCardController(PersonService personService, CreditCardService creditCardService, BankService bankService) {
        this.personService = personService;
        this.creditCardService = creditCardService;
        this.bankService = bankService;
    }

    @RequestMapping(value = "/main/tables/creditCard" )
    public String showCreditCards(Model model){
        logger.info("/main/tables/creditCard");
        logger.info(creditCardService.findAll());
        model.addAttribute("bank",bankService.findAll());
        model.addAttribute("person",personService.findAll());
        model.addAttribute("creditCards",creditCardService.findAll());
        return "tables/creditCard";
    }

    @RequestMapping(value = "/main/tables/creditCard/add" )
    public String addCreditCardForm(Model model) {
        model.addAttribute("persons",personService.findAll());
        model.addAttribute("banks",bankService.findAll());
        logger.info("/main/tables/creditCard/add");
        return "actions/addCreditCard";
    }

    @RequestMapping(value = "/main/tables/creditCard/addData",method = RequestMethod.POST )
    public String addCreditCardData(@Valid CreditCard creditCard, BindingResult result,@RequestParam("selected") int id,@RequestParam("selectedBank") int idBank){
        logger.info(creditCard);
        creditCard.setPrimaryPerson(personService.getPersonById(id));
        creditCard.setPrimaryBank(bankService.getBankById(idBank));
        logger.info(creditCard);
        logger.info(idBank);
        creditCardService.addCreditCard(creditCard);
        return "redirect:/main/tables/creditCard";
    }

    @RequestMapping(value = "/main/tables/creditCard/cancel")
    public String cancelCreditCard(){
        return "redirect:/main/tables/creditCard";
    }

    @RequestMapping(value = "/main/tables/creditCard/delete",method = RequestMethod.POST)
    public String deleteCreditCard(@RequestParam("idDelete") int id){
        creditCardService.deleteCreditCard(id);
        return "redirect:/main/tables/creditCard";
    }

    @RequestMapping(value = "/main/tables/creditCard/edit",method = RequestMethod.POST)
    public String editCreditCard(@RequestParam("idEdit") int id,Model model){
        logger.info("/main/tables/creditCard/edit");
        model.addAttribute("creditCards",creditCardService.findCreditCardById(id));
        model.addAttribute("chosenPerson",creditCardService.findCreditCardById(id).getPrimaryPerson());
        model.addAttribute("chosenBank",creditCardService.findCreditCardById(id).getPrimaryBank());
        return "/actions/editCreditCard";
    }

    @RequestMapping(value = "/main/tables/creditCard/editData",method = RequestMethod.POST)
    public String updateData(@ModelAttribute("editCreditCard") CreditCard creditCard,@RequestParam("getIdPerson") int idPerson,@RequestParam("getIdBank") int idBank){
        logger.info("/main/tables/creditCard/editData");
        logger.info(creditCard);
        logger.info(personService.getPersonById(idPerson));
        logger.info(bankService.getBankById(idBank));
        creditCard.setPrimaryPerson(personService.getPersonById(idPerson));
        creditCard.setPrimaryBank(bankService.getBankById(idBank));
        creditCardService.addCreditCard(creditCard);
        return "redirect:/main/tables/creditCard";
    }

    @RequestMapping(value = "/main/tables/creditCard/cancelCreditCard")
    public String goToBack(){
        return "redirect:/main/tables";
    }

}
