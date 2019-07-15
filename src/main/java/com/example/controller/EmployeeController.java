package com.example.controller;

import com.example.model.Employee;
import com.example.model.EmployeeGrade;
import com.example.model.Request;
import com.example.model.Vacancy;
import com.example.service.EmployeeGradeService;
import com.example.service.EmployeeService;
import com.example.service.RequestService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;
    private final RequestService requestService;
    private final EmployeeGradeService employeeGradeService;
    ;

    public EmployeeController(final EmployeeService employeeService, RequestService requestService, EmployeeGradeService employeeGradeService) {
        this.employeeService = employeeService;
        this.requestService = requestService;
        this.employeeGradeService = employeeGradeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(final ModelMap model) {

        LOGGER.info("EmployeeController#findAll");

        final List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employeeList", employeeList);

        return "employeeAll";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addEmployee(ModelMap model) {
        LOGGER.info("EmployerController#addEmployee");
        return "employeeAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployeePOST(@ModelAttribute("employee") Employee employee, ModelMap model) {
        LOGGER.info("EmployerController#addEmployeePOST");

        employeeService.addEmployee(employee);

        return "redirect:/employee/" + employee.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String employeeAccount(@PathVariable long id, ModelMap model) {
        LOGGER.info("EmployeeController#employeeAccount");

        final Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employeeAccount";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String employeeAccountPOST(@RequestParam("id") long id, @RequestParam("command") String command, ModelMap model) {
        LOGGER.info("EmployeeController#employeeAccountPOST");

        switch (command) {
            case "requests":
                return "redirect:/employee/" + id + "/requests";
            default:
                return "redirect:/employee/" + id;
        }
    }

    @RequestMapping(value = "/{id}/requests", method = RequestMethod.GET)
    public String requestsByEmployee(@PathVariable long id, ModelMap model, Principal principal) {
        LOGGER.info("EmployeeController#requestsByEmployee");

        final List<Request> requests = employeeService.findRequestsByEmployee(id);

        model.addAttribute("requests", requests);
        model.addAttribute("employeeId", id);

        return "employeeAllRequests";
    }

    @RequestMapping(value = "/{id}/requests", method = RequestMethod.POST)
    public String requestsByEmployeePOST(@RequestParam("id") long id, @RequestParam("command") String command, ModelMap model) {
        LOGGER.info("EmployeeController#requestsByEmployeePOST");
        switch (command) {
            case "add":
                return "redirect:/employee/" + id + "/requests/add";
            case "delete":
                return "redirect:/employee/" + id + "/requests/delete";
            case "find_vacancies":
                return "redirect:/employee/" + id + "/requests/find_vacancies";
            default:
                return "redirect:/employee/" + id + "/requests";
        }
    }

    @RequestMapping(value = "/{id}/requests/add", method = RequestMethod.GET)
    public String addRequest(@PathVariable long id, ModelMap model) {
        LOGGER.info("EmployeeController#addRequest");

        model.addAttribute("employeeId", id);

        return "employeeAddRequest";
    }

    @RequestMapping(value = "/{id}/requests/add", method = RequestMethod.POST)
    public String addRequestPOST(@ModelAttribute("request") Request request, @RequestParam("employeeId") long id, ModelMap model) {
        LOGGER.info("EmployeeController#addRequestPOST");

        request.setEmployee(employeeService.findById(id));

        requestService.addRequest(request);

        return "redirect:/employee/" + id + "/requests";
    }

    @RequestMapping(value = "/{id}/requests/find_vacancies", method = RequestMethod.GET)
    public String findVacancies(@PathVariable long id, ModelMap model) {
        LOGGER.info("EmployeeController#findVacancies");

        model.addAttribute("employeeId", id);

        return "employeeFindVacancies";
    }

    @RequestMapping(value = "/{id}/requests/find_vacancies", method = RequestMethod.POST)
    public String findVacanciesPOST(@RequestParam("id") long id, @RequestParam("req_id") long req_id, ModelMap model) {
        LOGGER.info("EmployeeController#findVacanciesPOST");

        return "redirect:/employee/" + id + "/requests/find_vacancies/" + req_id;
    }

    @RequestMapping(value = "/{id}/requests/delete", method = RequestMethod.GET)
    public String deleteRequest(@PathVariable long id, ModelMap model) {
        LOGGER.info("EmployeeController#deleteRequest");

        model.addAttribute("employeeId", id);

        return "employeeDeleteRequest";
    }

    @RequestMapping(value = "/{id}/requests/delete", method = RequestMethod.POST)
    public String deleteRequestPOST(@RequestParam("id") long id, @RequestParam("req_id") long req_id, ModelMap model) {
        LOGGER.info("EmployeeController#deleteRequestPOST");

        requestService.deleteRequest(req_id);

        return "redirect:/employee/" + id + "/requests";
    }

    @RequestMapping(value = "/{id}/requests/find_vacancies/{req_id}", method = RequestMethod.GET)
    public String findVacanciesByRequest(@PathVariable long id, @PathVariable long req_id, ModelMap model) {
        LOGGER.info("EmployeeController#findVacanciesByRequest");

        final Request request = requestService.findById(req_id);
        final List<Vacancy> vacancies = requestService.findVacancies(req_id);

        model.addAttribute("request", request);
        model.addAttribute("vacancies", vacancies);

        return "vacanciesByRequest";
    }

    @RequestMapping(value = "/{id}/grades")
    public String gradesByEmployee(@PathVariable long id, ModelMap model) {// несоответствующее название
        LOGGER.info("EmployerController#gradesByEmployee");

        final List<EmployeeGrade> employeeGrades = employeeService.findGradeByEmployee(id);

        model.addAttribute("employeeId", id);
        model.addAttribute("grades", employeeGrades);

        return "employeeAllGrades";
    }

}
