package com.example.service;

import com.example.model.Request;
import com.example.model.Vacancy;
import com.example.repository.VacancyRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by staliah on 19.06.2019.
 */
@Component
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;

    public VacancyServiceImpl(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    @Transactional
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    @Transactional
    public Vacancy findById(Long id) {
        return vacancyRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Request> findRequests(long id) {
        return vacancyRepository.findRequest(id);
    }

    @Override
    @Transactional
    public void addVacancy(Vacancy vacancy) {
        vacancyRepository.addVacancy(vacancy);
    }

    @Override
    public void deleteVacancy(long id) {
        vacancyRepository.deleteVacancy(id);
    }


}
