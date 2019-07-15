package com.example.repository;

import com.example.model.Request;
import com.example.model.Vacancy;
import org.apache.log4j.Logger;
import org.h2.command.dml.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class RequestRepositoryImpl implements RequestRepository {

    private static final Logger LOGGER = Logger.getLogger(RequestRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Request> findAll() {
        LOGGER.info("RequestRepositoryImpl#findAll");

        return sessionFactory.getCurrentSession().createQuery("SELECT r FROM request r").list();
    }

    @Override
    public Request findById(Long id) {
        LOGGER.info("RequestRepositoryImpl#findById");

        return (Request) sessionFactory.getCurrentSession().createQuery("SELECT r FROM request r WHERE r.id   =" + id).uniqueResult();
    }

    @Override
    public List<Vacancy> findVacancies(Long id) {
        LOGGER.info("RequestRepositoryImpl#findById");

        Request request = (Request)sessionFactory.getCurrentSession().createQuery("SELECT r FROM request r WHERE r.id =" + id).uniqueResult();

        org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery("SELECT v from vacancy v where v.country.id = :countryId and " +
                "(v.profession.id = :professionId) and " +
                "((v.maxSalary between :minSalary and :maxSalary) or (v.minSalary between :minSalary and :maxSalary))");
        query.setParameter("countryId", request.getCountry().getId());
        query.setParameter("minSalary", request.getMinSalary());
        query.setParameter("maxSalary", request.getMaxSalary());
        query.setParameter("professionId", request.getProfession().getId());
        return query.list();
    }

    @Override
    public void addRequest(Request req){
        sessionFactory.getCurrentSession().save(req);
    }

    @Override
    @Transactional
    public void deleteRequest(Long id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }
}
