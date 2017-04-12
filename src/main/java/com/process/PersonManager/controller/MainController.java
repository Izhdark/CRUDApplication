package com.process.PersonManager.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Кирилл on 09.02.2017.
 */
@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/main")
    public String ShowMainMenu(Model model){
        logger.info("/main");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name=auth.getAuthorities().toString();
        logger.info(auth);
        model.addAttribute("ANONYMOUS",false);
        model.addAttribute("USER",false);
        if(name.equals("[ROLE_ANONYMOUS]")){
            model.addAttribute("ANONYMOUS",true);
        }
        if(auth.getAuthorities().toString().equals("[User]")){
            model.addAttribute("USER",true);
        }
        logger.info(auth.getPrincipal());
        model.addAttribute("account",auth.getName());
        return "main";
    }
    @RequestMapping(value = "/main/tables")
    public String showTables(){
        logger.info("/main/tables");
        return "tables";
    }
    @RequestMapping(value = "/mainMenu")
    public String save(){
        return "redirect:/main";
    }
}
