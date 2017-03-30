package com.process.PersonManager.controller.PersonControllers;

import com.process.PersonManager.model.contentModel.Purchase;
import com.process.PersonManager.service.contentService.CreditCardService;
import com.process.PersonManager.service.contentService.PurchaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by Кирилл on 22.02.2017.
 */
@Controller
public class PurchaseController {

    private static final Logger logger = Logger.getLogger(PersonController.class);

    private final PurchaseService purchaseService;

    private final CreditCardService creditCardService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, CreditCardService creditCardService) {
        this.purchaseService = purchaseService;
        this.creditCardService = creditCardService;
    }

    @RequestMapping(value = "/main/tables/purchase")
    public String showPrchase(Model model){
        model.addAttribute("purchases",purchaseService.findAll());
        return "tables/purchase";
    }

    @RequestMapping(value = "/main/tables/purchase/add")
    public String addForm(Model model){
        model.addAttribute("creditCards",creditCardService.findAll());
        logger.info(creditCardService.findAll());
        logger.info("/main/tables/purchase/add");
        return "actions/addPurchase";
    }

    @RequestMapping(value = "/main/tables/purchase/addPurchase",method = RequestMethod.POST)
    public String addPurchase(@Valid Purchase purchase, @RequestParam("selected") int id){
        logger.info("/main/tables/purchase/addPurchase");
        purchase.setPrimaryCreditCard(creditCardService.findCreditCardById(id));
        logger.info(purchase);
        purchaseService.addPurchase(purchase);
        return "redirect:/main/tables/purchase";
    }

    @RequestMapping(value = "/main/tables/purchase/add/cancel")
    public String cancelAddForm(){

        return "redirect:/main/tables/purchase";
    }
    @RequestMapping(value = "/main/tables/purchase/delete")
    public String delete(@RequestParam("getIdPurchase") int id){
        purchaseService.deletePurchase(id);
        return "redirect:/main/tables/purchase";
    }

    @RequestMapping(value = "/main/tables/purchase/edit")
    public String editForm(@RequestParam("edit") int id, Model model){
        model.addAttribute("purchase",purchaseService.findPurchaseById(id));
        model.addAttribute("card",purchaseService.findPurchaseById(id).getPrimaryCreditCard());
        return "actions/editPurchase";
    }

    @RequestMapping(value = "/main/tables/purchase/updatePurchase")
    public String updateData(@Valid Purchase purchase,@RequestParam("getIdCard") int id){
        purchase.setPrimaryCreditCard(creditCardService.findCreditCardById(id));
        purchaseService.addPurchase(purchase);
        return "redirect:/main/tables/purchase";
    }
}
