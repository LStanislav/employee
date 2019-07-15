package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by staliah on 05.06.2019.
 */

@Entity(name = "employer")
public class Employer {
    private long id;
    private String organization;
    private boolean verification;
    private String contacts;
    private Set<Vacancy> vacancy;
    private Set<EmployerGrade> employerGrades;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ORGANIZATION")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Column(name = "VERIFICATION")
    public boolean getVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    @Column(name = "CONTACTS")
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @OneToMany(mappedBy = "employer")
    public Set<Vacancy> getVacancy() {
        return vacancy;
    }

    public void setVacancy(Set<Vacancy> vacancy) {
        this.vacancy = vacancy;
    }

    @OneToMany(mappedBy = "employer")
    public Set<EmployerGrade> getEmployerGrades() {
        return employerGrades;
    }

    public void setEmployerGrades(Set<EmployerGrade> employerGrades) {
        this.employerGrades = employerGrades;
    }
}
