package com.example.repository;

import com.example.model.Request;
import com.example.model.Vacancy;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.beans.Transient;
import java.util.List;

/**
 * Created by staliah on 19.06.2019.
 */
@Component
public class VacancyRepositoryImpl implements VacancyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Vacancy> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select v from vacancy v").list();
    }

    @Override
    public Vacancy findById(Long id) {
        return (Vacancy) sessionFactory.getCurrentSession().createQuery("select v from vacancy v where v.id =" + id).uniqueResult();
    }

    @Override
    public List<Request> findRequest(Long id) {
        Vacancy vacancy = this.findById(id);

//        Query query = sessionFactory.getCurrentSession().createQuery("select r from request r where r.county.id = :contry");
        org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery("SELECT r from request r where r.country.id = :countryId and " +
                "(r.profession.id = :professionId) and " +
                "((r.maxSalary between :minSalary and :maxSalary) or (r.minSalary between :minSalary and :maxSalary))");
        query.setParameter("countryId", vacancy.getCountry().getId());
        query.setParameter("minSalary", vacancy.getMinSalary());
        query.setParameter("maxSalary", vacancy.getMaxSalary());
        query.setParameter("professionId", vacancy.getProfession().getId());
        return query.list();
    }

    @Override
    public void addVacancy(Vacancy vacancy) {
        sessionFactory.getCurrentSession().save(vacancy);
    }

    @Override
    @Transactional
    public void deleteVacancy(Long id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

}
