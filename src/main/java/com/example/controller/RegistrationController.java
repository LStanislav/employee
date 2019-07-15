package com.example.controller;

import com.example.model.Employee;
import com.example.model.Employer;
import com.example.service.EmployeeService;
import com.example.service.EmployerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by staliah on 12.06.2019.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final EmployeeService employeeService;
    private final EmployerService employerService;

    public RegistrationController(EmployeeService employeeService, EmployerService employerService) {
        this.employeeService = employeeService;
        this.employerService = employerService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String registration(final ModelMap model) {
        return "registration";
    }

}
