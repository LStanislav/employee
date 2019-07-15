package com.example.repository;

import com.example.model.Employer;
import com.example.model.Vacancy;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployerRepositoryImpl implements EmployerRepository {
    private static final Logger LOGGER = Logger.getLogger(EmployerRepositoryImpl.class);


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Employer> findAll() {
        LOGGER.info("EmployerRepositoryImpl#findAll");

        return sessionFactory.getCurrentSession().createQuery("SELECT e FROM employer e").list();
    }

    @Override
    public Employer findById(Long id) {
        LOGGER.info("EmployerRepositoryImpl#findById");

        return (Employer) sessionFactory.getCurrentSession().createQuery("SELECT e FROM employer e WHERE e.id   =" + id).uniqueResult();
    }

    @Override
    public void addEmployer(Employer empl){
        sessionFactory.getCurrentSession().save(empl);
    }


}
