package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SkillController {



    @Autowired
    private SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public SkillRepository getSkillRepository() {
        return skillRepository;
    }

    public void setSkillRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }}


