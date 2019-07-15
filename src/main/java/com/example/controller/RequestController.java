package com.example.controller;

import com.example.model.Request;
import com.example.service.RequestService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {

    private static final Logger LOGGER = Logger.getLogger(RequestController.class);

    private final RequestService requestService;

    public RequestController(final RequestService requestService) {
        this.requestService = requestService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAll(final ModelMap model) {
        LOGGER.info("RequestController#findAll");

        final List<Request> requestList = requestService.findAll();

        LOGGER.info("requestList: " + requestList);

        model.addAttribute("requests", requestList);

        return "requestAll";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable final long id, final ModelMap model) {
        LOGGER.info("RequestController#findById");

        final Request request = requestService.findById(id);

        LOGGER.info("request: " + request);

        model.addAttribute("request", request);

        return "requestById";
    }
}


