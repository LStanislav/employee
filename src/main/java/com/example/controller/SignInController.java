package com.example.controller;

import com.example.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by staliah on 12.06.2019.
 */

@Controller
@RequestMapping("sign_in")
public class SignInController {

    private final EmployeeService employeeService;
    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);


    public SignInController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String signIn(final ModelMap model){
        LOGGER.info("SignInController#signIn");
        return "signIn";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String signInPOST(@RequestParam("id") Long id, @RequestParam("command") String command, final ModelMap model){
        LOGGER.info("SignInController#signInPOST");
        if (command.equals("employee")) {
            return "redirect:/employee/" + id;
        }
        else {
            return "redirect:/employer/" + id;
        }
    }
}
