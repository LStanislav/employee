package com.example.service;

import com.example.model.Request;
import com.example.model.Vacancy;
import com.example.repository.RequestRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RequestServiceImpl implements RequestService {

    private static final Logger LOGGER = Logger.getLogger(RequestServiceImpl.class);

    private final RequestRepository requestRepository;


    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }


    @Override
    @Transactional
    public List<Request> findAll() {
        LOGGER.info("RequestServiceImpl#findAll");

        return requestRepository.findAll();
    }

    @Override
    @Transactional
    public Request findById(Long id) {
        LOGGER.info("RequestServiceImpl#findById");

        return requestRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Vacancy> findVacancies(long id){
        return requestRepository.findVacancies(id);
    }

    @Override
    @Transactional
    public void addRequest(Request request){
        requestRepository.addRequest(request);
    }

    @Override
    @Transactional
    public void deleteRequest(long id) {
        requestRepository.deleteRequest(id);
    }
}
