package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
@Controller
@RequestMapping("employers")
public class EmployerController {
    //Add a private field of EmployerRepository type called employerRepository to EmployerController. Give this field an @Autowired annotation.
@Autowired
private EmployerRepository employerRepository;

    public EmployerController(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        model.addAttribute ( "employerID" );
        return "employers/add";
    }
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer, Errors errors, Model model) {
        if (errors.hasErrors ()) {
            model.addAttribute ( "title", "Add Employer" );
            // return "employers/add";
        }
        employerRepository.save ( newEmployer );
         return "redirect:../";
    }
//SEND BACK IF INVALID
    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {
        Optional optEmployer = employerRepository.findById (employerId);
        if (optEmployer.isPresent ()) {
            Employer employer = (Employer) optEmployer.get ();
            model.addAttribute ( "employer", employer );
            return "view";
        } else {
            return "redirect:../";
        }
    }
    //public Optional findById() {
       // return null;
    }
  //  }

    //User findByUsername(String username);