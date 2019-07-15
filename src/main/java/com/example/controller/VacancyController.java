package com.example.controller;

import com.example.model.Vacancy;
import com.example.service.VacancyService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/vacancy")
public class VacancyController {

    private static final Logger LOGGER = Logger.getLogger(VacancyController.class);

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAll(final ModelMap model) {
        LOGGER.info("VacancyController#findAll");

        final List<Vacancy> vacancyList = vacancyService.findAll();

        LOGGER.info("vacancyList: " + vacancyList);

        model.addAttribute("vacancies", vacancyList);

        return "vacancyAll";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable final long id, final ModelMap model) {
        LOGGER.info("VacancyController#findById");

        final Vacancy vacancy = vacancyService.findById(id);

        LOGGER.info("vacancy: " + vacancy);

        model.addAttribute("vacancy", vacancy);

        return "vacancyById";
    }
}


