package com.example.service;

import com.example.model.Employer;
import com.example.model.EmployerGrade;
import com.example.model.Vacancy;
import com.example.repository.EmployerGradeRepository;
import com.example.repository.EmployerRepository;
import com.example.repository.VacancyRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployerServiceImpl implements EmployerService {
    private static final Logger LOGGER = Logger.getLogger(EmployerServiceImpl.class);

    private final EmployerRepository employerRepository;
    private final VacancyRepository vacancyRepository;
    private final EmployerGradeRepository employerGradeRepository;


    public EmployerServiceImpl(final EmployerRepository employerRepository, VacancyRepository vacancyRepository, EmployerGradeRepository employerGradeRepository) {
        this.employerRepository = employerRepository;
        this.vacancyRepository = vacancyRepository;
        this.employerGradeRepository = employerGradeRepository;
    }

    @Override
    @Transactional
    public List<Employer> findAll() {
        LOGGER.info("EmployerServiceImpl#findAll");

        return employerRepository.findAll();
    }

    @Override
    @Transactional
    public Employer findById(Long id) {
        return employerRepository.findById(id);
    }

    @Override
    @Transactional
    public void addEmployer(Employer employer){employerRepository.addEmployer(employer);}

    @Override
    @Transactional
    public List<Vacancy> findVacancyByEmployer(Long employerId) {
        LOGGER.info("EmployerServiceImpl#findVacancyByEmployer");
        Employer employer = employerRepository.findById(employerId);

        final List<Long> vacanciesIds = employer.getVacancy().stream().map(Vacancy::getId).collect(Collectors.toList());

        return vacanciesIds.stream().map(vacancyRepository::findById).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<EmployerGrade> findGradeByEmployer(Long employerId) {
        LOGGER.info("EmployerServiceImpl#findGradeByEmployer");
        Employer employer = employerRepository.findById(employerId);

//        final List<Long> vacanciesIds = employer.getVacancy().stream().map(Vacancy::getId).collect(Collectors.toList());
        final List<Long> gradesIds = employer.getEmployerGrades().stream().map(EmployerGrade::getId).collect(Collectors.toList());

//        return vacanciesIds.stream().map(vacancyRepository::findById).collect(Collectors.toList());
        return gradesIds.stream().map(employerGradeRepository::findById).collect(Collectors.toList());
    }
}
