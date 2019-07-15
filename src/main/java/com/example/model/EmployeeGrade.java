package com.example.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity(name = "employee_grade")
public class EmployeeGrade {
    private long id;
    private int mark;
    private String comment;
    private Employee employee;

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
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
