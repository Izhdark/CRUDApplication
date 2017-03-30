package com.process.PersonManager.controller.LoginAndAutorizationFormController;

import com.process.PersonManager.model.loginForm.User;
import com.process.PersonManager.model.loginForm.VerificationToken;
import com.process.PersonManager.service.userService.SecurityService;
import com.process.PersonManager.service.userService.UserService;
import com.process.PersonManager.utils.ErrorMessage;
import com.process.PersonManager.utils.Listener.OnRegistrationCompleteEvent;
import com.process.PersonManager.utils.Validation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;

@Controller
public class RegistrationController {

    private static final Logger logger = Logger.getLogger(RegistrationController.class);

    private final UserService userService;

    private final Validation validation;

    private final SecurityService securityService;

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public RegistrationController(UserService userService, Validation validation, SecurityService securityService, ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.validation = validation;
        this.securityService = securityService;
        this.eventPublisher = eventPublisher;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        logger.info("/registration");
        model.addAttribute("message", false);
        logger.info(model.toString());
        return "auth/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerNewAccount(@Valid User user, Errors errors, Model model, WebRequest webRequest) {
        validation.validate(user, errors);
        if (errors.hasErrors()) {
            model.addAttribute("message", false);
            return "auth/registration";
        }
        String appUrl = webRequest.getContextPath();
        User registered = userService.createNewUserAccount(user);
        logger.info(registered);
        model.addAttribute("message", true);
        model.addAttribute("email", user.getEmail());
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, appUrl, webRequest.getLocale()));
        return "auth/registration";
    }

    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration
            (WebRequest request, Model model, @RequestParam("token") String token) {
        logger.info(token);
        User verificationToken = userService.findByToken(token);
        logger.info(token);
        if (verificationToken == null) {
            model.addAttribute("message", ErrorMessage.TOKEN_NOT_VALID);
            return "redirect:/badUser.html?lang=";
        }
        Calendar cal = Calendar.getInstance();
        VerificationToken vertoken = new VerificationToken();
        logger.info(vertoken.getExpiration());
/*        if(vertoken.getExpiration()-verificationToken.getCreation_date().getTime()<=0){
            model.addAttribute("message",ErrorMessage.TOKEN_NOT_VALID);
            userService.deleteUser(verificationToken);
            return "redirect:/badUser.html?lang=";
        }*/
        logger.info(verificationToken);
        return "redirect:/login";
    }
}
