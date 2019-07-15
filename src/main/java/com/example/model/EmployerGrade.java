package com.example.model;

import javax.persistence.*;

@Entity(name = "employer_grade")
public class EmployerGrade {
    private long id;
    private int mark;
    private String comment;
    private Employer employer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRADE_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "MARK")
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
