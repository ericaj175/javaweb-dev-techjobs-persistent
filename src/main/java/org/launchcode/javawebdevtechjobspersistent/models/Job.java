package org.launchcode.javawebdevtechjobspersistent.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Job extends AbstractEntity { //publicabstractforajob class -systems for objects

    @ManyToMany
    private List<Skill> skills;

    @ManyToOne
    private Employer employer;

    public Job() {
    } //constructor-method that builds your object. takes your abstract and makes it concrete

    public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }
    // Getters and setters.

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skill) {
        this.skills = skill;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }


}
