package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;

@Entity
public class Job extends AbstractEntity { //publicabstractforajob class -systems for objects
    @Id
    @GeneratedValue
    private int id;
    private String skills;
    private String name;

    @ManyToOne
    private Employer employer;

    public Job() {
    } //constructor-method that builds your object. takes your abstract and makes it concrete
    public Job(Employer anEmployer, String someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }
    // Getters and setters.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployer() {
        return getEmployer();
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
