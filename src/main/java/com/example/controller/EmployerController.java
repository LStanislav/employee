package com.example.controller;

import com.example.model.*;
import com.example.service.EmployerGradeService;
import com.example.service.EmployerService;
import com.example.service.VacancyService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    private static final Logger LOGGER = Logger.getLogger(EmployerController.class);

    private final EmployerService employerService;
    private final VacancyService vacancyService;
    private final EmployerGradeService employerGradeService;

    public EmployerController(final EmployerService employerService, VacancyService vacancyService, EmployerGradeService employerGradeService) {
        this.employerService = employerService;
        this.vacancyService = vacancyService;
        this.employerGradeService = employerGradeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(final ModelMap model) {
        LOGGER.info("EmployerController#findAll");

        final List<Employer> employerList = employerService.findAll();

        model.addAttribute("employerList", employerList);

        return "employerAll";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addEmployer(ModelMap model){
        LOGGER.info("EmployerController#addEmployer");

        return "employerAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployerPOST(@ModelAttribute("employer") Employer employer,ModelMap model){
        LOGGER.info("EmployerController#addEmployerPOST");

        employerService.addEmployer(employer);

        return "redirect:/employer/" + employer.getId();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String employerAccount(@PathVariable final long id, final ModelMap model) {
        LOGGER.info("EmployerController#employerAccount");

        final Employer employer = employerService.findById(id);

        model.addAttribute("employer", employer);

        return "employerAccount";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String employerAccountPOST(@RequestParam("id") final long id, @RequestParam("command") final String command, final ModelMap model) {
        LOGGER.info("EmployerController#employerAccountPOST");

        switch (command) {
            case "vacancies":
                return "redirect:/employer/" + id + "/vacancies";
            default:
                return "redirect:/employer/" + id;
        }
    }

    @RequestMapping(value = "{id}/vacancies", method = RequestMethod.GET)
    public String vacanciesByEmployer(@PathVariable final long id, ModelMap model){
        LOGGER.info("EmployerController#vacanciesByEmployer");

        List<Vacancy> vacancies = employerService.findVacancyByEmployer(id);

        model.addAttribute("vacancies", vacancies);
        model.addAttribute("employerId", id);

        return "employerAllVacancies";
    }

    @RequestMapping(value = "{id}/vacancies", method = RequestMethod.POST)
    public String vacanciesByEmployerPOST(@RequestParam("id") final long id, @RequestParam("command") String command, ModelMap model){
        LOGGER.info("EmployerController#vacanciesByEmployerPOST");

        return "redirect:/employer/" + id + "/vacancies/" + command;

//        switch (command) {
//            case "add":
//                return "redirect:/employer/" + id + "/vacancies/add";
//            case "delete":
//                return "redirect:/employer/" + id + "/vacancies/delete";
//            case "find_requests":
//                return "redirect:/employer/" + id + "/vacancies/find_requests";
//            default:
//                return "redirect:/employee/" + id + "/vacancies";
//        }
    }

    @RequestMapping(value = "{id}/vacancies/add", method = RequestMethod.GET)
    public String addVacancy(@PathVariable final long id, ModelMap model){
        LOGGER.info("EmployerController#addVacancy");

        model.addAttribute("employerId", id);

        return "employerAddVacancy";
    }

    @RequestMapping(value = "{id}/vacancies/add", method = RequestMethod.POST)
    public String addVacancyPOST(@ModelAttribute("vacancy") Vacancy vacancy, @RequestParam("employerId") final long id, ModelMap model){
        LOGGER.info("EmployerController#addVacancyPOST");

        vacancy.setEmployer(employerService.findById(id));

        vacancyService.addVacancy(vacancy);

        return "redirect:/employer/" + id + "/vacancies";
    }

    @RequestMapping(value = "{id}/vacancies/find_requests", method = RequestMethod.GET)
    public String findRequests(@PathVariable final long id, ModelMap model){
        LOGGER.info("EmployerController#findRequests");

        model.addAttribute("employerId", id);

        return "employerFindRequests";
    }

    @RequestMapping(value = "{id}/vacancies/find_requests", method = RequestMethod.POST)
    public String findRequestsPOST(@RequestParam("id") final long id, @RequestParam("vac_id") long vac_id, ModelMap model){
        LOGGER.info("EmployerController#findRequestsPOST");

        return "redirect:/employer/" + id + "/vacancies/find_requests/" + vac_id;
    }

    @RequestMapping(value = "{id}/vacancies/delete", method = RequestMethod.GET)
    public String deleteVacancy(@PathVariable final long id, ModelMap model){
        LOGGER.info("EmployerController#deleteVacancy");

        model.addAttribute("employerId", id);

        return "employerDeleteVacancy";
    }

    @RequestMapping(value = "{id}/vacancies/delete", method = RequestMethod.POST)
    public String deleteVacancyPOST(@RequestParam("id") final long id, @RequestParam("vac_id") final long vac_id, ModelMap model){
        LOGGER.info("EmployerController#deleteVacancyPOST");

        vacancyService.deleteVacancy(vac_id);

        return "redirect:/employer/" + id + "/vacancies";
    }

    @RequestMapping(value = "{id}/vacancies/find_requests/{vac_id}", method = RequestMethod.GET)
    public String findRequestsByVacancy(@PathVariable final long id,@PathVariable final long vac_id, ModelMap model){
        LOGGER.info("EmployerController#findRequestsByVacancy");

        final Vacancy vacancy = vacancyService.findById(vac_id);
        final List<Request> requests = vacancyService.findRequests(vac_id);

        model.addAttribute("vacancy", vacancy);
        model.addAttribute("requests", requests);

        return "requestsByVacancy";
    }

    @RequestMapping(value = "/{id}/grades")
    public String gradesByEmployer(@PathVariable long id, ModelMap model) {// несоответствующее название
        LOGGER.info("EmployerController#gradesByEmployer");

        final List<EmployerGrade> employerGrades = employerService.findGradeByEmployer(id);

        model.addAttribute("employerId", id);
        model.addAttribute("grades", employerGrades);

        return "employerAllGrades";
    }
}
