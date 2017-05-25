package com.process.PersonManager.controller.PersonControllers;

import com.process.PersonManager.model.contentModel.Person;
import com.process.PersonManager.service.contentService.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Кирилл on 16.02.2017.
 */
@Controller
public class PersonController {

    private final PersonService personService;

    private static final Logger logger = Logger.getLogger(PersonController.class);

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/main/tables/person")
    public String showPerson(Model model){
        model.addAttribute("persons",personService.findAll());
        return "tables/person";
    }

    @RequestMapping(value = "/main/tables/person/add")
    public String addForm(){
        return "actions/add";
    }

    @RequestMapping(value = "/main/tables/dataPerson", method = RequestMethod.POST)
    public String addData(@ModelAttribute("personId") Person person ){
        personService.addPerson(person);
        return "redirect:/main/tables/person";
    }

    @RequestMapping(value = "/main/tables/person/delete",method = RequestMethod.POST)
    public String deleteData(@RequestParam("getIdToDelete") int id){
        personService.deletePerson(id);
        return "redirect:/main/tables/person";
    }

    @RequestMapping(value = "/main/tables/person/edit")
    public String showUpdateDataForm(@RequestParam("getIdToUpdate") int id, Model model){
        model.addAttribute("personData", personService.getPersonById(id));
        return "/actions/editPerson";
    }

    @RequestMapping(value = "/main/tables/person/cancel")
    public String cancel(){
        return "redirect:/main/tables/person";
    }

    @RequestMapping(value = "/main/tables/updatePerson")
    public String updateData(@ModelAttribute("updatePersons") Person person){
       personService.updatePerson(person.getFirstName(),person.getLastName(),person.getBirthDate(),person.getId());
       return "redirect:/main/tables/person";
    }

    @RequestMapping(value = "/main/tables/person/creditCards")
    public String showCreditCards(@RequestParam("idCreditCard") int id,Model model){
        model.addAttribute("cards",personService.getPersonById(id).getPersonList());
        return "/tables/showdata/showCreditCard";
    }

    @RequestMapping(value = "/main/tables/showCreditCard/cancel")
    public String cancelCreditCards(){
        return "redirect:/main/tables/person";
    }
    @RequestMapping(value = "/main/tables/person/cancelBack")
    public String backToMainMenu(){
        return "redirect:/main/tables/";
    }
}
