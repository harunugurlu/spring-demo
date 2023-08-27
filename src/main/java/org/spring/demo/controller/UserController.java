package org.spring.demo.controller;

import org.spring.demo.model.Store;
import org.spring.demo.model.User;
import org.spring.demo.service.UserPersistence;
import org.spring.demo.service.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    UserPersistence persistenceService = new UserPersistence();

    /*@RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String user() {
        return "create-user";
    }*/
    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String createUser(ModelMap modelMap, @RequestParam String name, @RequestParam String email, @RequestParam String address) {

        UserValidator userValidator = new UserValidator();

        User existingUser = userValidator.isValidUser(name);

        if(existingUser == null) {
            User newUser = new User(name, email, address);

            persistenceService.saveUser(newUser);

            String message = "SUCCESSFULLY CREATED USER: " + name;
            modelMap.addAttribute("message", message);

            modelMap.addAttribute("name", name);
            modelMap.addAttribute("email", email);
            modelMap.addAttribute("address", address);
        }
        else {
            String message = "USER: " + name + " ALREADY EXISTS";
            modelMap.addAttribute("message", message);

            modelMap.addAttribute("name", existingUser.getName());
            modelMap.addAttribute("email", existingUser.getEmail());
            modelMap.addAttribute("address", existingUser.getAddress());
        }

        return "create_user";
    }
}
