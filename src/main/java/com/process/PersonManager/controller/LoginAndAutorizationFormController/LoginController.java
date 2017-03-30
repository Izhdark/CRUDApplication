package com.process.PersonManager.controller.LoginAndAutorizationFormController;

import com.process.PersonManager.service.userService.SecurityService;
import com.process.PersonManager.service.userService.UserService;
import com.process.PersonManager.utils.Validation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Кирилл on 06.03.2017.
 */
@Controller
public class LoginController{

    private static final Logger logger = Logger.getLogger(LoginController.class);

    private final UserService userService;

    private final Validation validation;

    private final SecurityService securityService;

    @Autowired
    public LoginController(UserService userService, Validation validation, SecurityService securityService) {
        this.userService = userService;
        this.validation = validation;
        this.securityService = securityService;
    }

    @RequestMapping(value = "/")
    public String WelcomePage(Model model){
        return "redirect:/main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(@RequestParam(value = "error", required = false) String error,
                                Model model) {
        model.addAttribute("error", error != null);
        logger.info(model.toString());
        return "auth/login";
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info(auth);
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "/";
    }


    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String adminPanel(){
        return "admin/showUsers";
    }

}
