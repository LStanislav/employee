package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by staliah on 04.06.2019.
 */

@Entity(name = "profession")
public class Profession {
    private long id;
    private String name;
    private Set<Request> requests;

    @Id
    @Column(name = "PROF_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "PROF_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "profession")
    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

}
