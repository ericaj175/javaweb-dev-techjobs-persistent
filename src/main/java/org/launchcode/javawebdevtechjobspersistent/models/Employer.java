package org.launchcode.javawebdevtechjobspersistent.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Employer extends AbstractEntity {

    @NotBlank
    @Size(min = 3, message = "Username must be minimum 3")
    public String location;

    @OneToMany
    @JoinColumn(name="employer_id")
    private final List<Job> jobs = new ArrayList<> ();
    //CONSTRUCTOR
    public Employer() {
    }
    //GETTERS SETTERS
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
