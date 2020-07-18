package org.launchcode.javawebdevtechjobspersistent.models;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {


    @NotBlank
    @Size(min = 3, message = "Username must be minimum 3")
    public String location;

    @OneToMany
    @JoinColumn(name="employer_id")
    private final List<Job> jobs = new ArrayList<> ();

    public Employer() {
    }

//constructor after fields
    public String getLocation() {
        return location;

    }

    public void setLocation(String location) {
        this.location = location;
    }
}
