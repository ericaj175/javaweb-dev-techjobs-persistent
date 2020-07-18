package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    @ManyToMany(mappedBy ="skills")
    private final List<Job> jobs = new ArrayList<> ();

    public String description;

    public List<Job> getJobs() {
        return jobs;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}


///Property field attribute=object akanoun
//function method=verb
//a class is what defines an object

//abstact non real or the conccept vs concrete real vs non real

//abstract--