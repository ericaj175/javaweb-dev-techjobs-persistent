package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.JobData;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobspersistent.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

//    @PostMapping("results")
//    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
//        Iterable<Job> jobs;
//        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
//            jobs = jobRepository.findAll();
//            return "results";
//        } else {
//            jobs = JobData.findByColumnAndValue(searchType, searchTerm, jobRepository.findAll());
//        }
//        model.addAttribute("columns", columnChoices);
//        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
//        model.addAttribute("jobs", jobs);
//
//        return "templates/search";
        @PostMapping(value ="results")

        public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
            model.addAttribute("columns", columnChoices);
            Iterable<Job> jobs;
            if (searchType.toLowerCase().equals("all") || searchType.equals ("")){
                jobs = jobRepository.findAll();

            } else {
                jobs = JobData.findByColumnAndValue(searchType, searchTerm, jobRepository.findAll());
                model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
            }
            model.addAttribute("jobs", jobs);
            return "search";
    }
}

