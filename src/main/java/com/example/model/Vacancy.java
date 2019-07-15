package com.example.model;

import javax.persistence.*;

/**
 * Created by staliah on 05.06.2019.
 */
@Entity(name = "vacancy")
public class Vacancy {
    private long id;
    private Country country;
    private Profession profession;
    private int minSalary;
    private int maxSalary;
    private boolean house;
    private Employer employer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VACANCY_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @ManyToOne
    @JoinColumn(name = "prof_id")
    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Column(name = "MIN_SALARY")
    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    @Column(name = "MAX_SALARY")
    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Column(name = "HOUSE")
    public boolean getHouse() {
        return house;
    }

    public void setHouse(boolean house) {
        this.house = house;
    }

    @ManyToOne
    @JoinColumn(name = "empl_id")
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
