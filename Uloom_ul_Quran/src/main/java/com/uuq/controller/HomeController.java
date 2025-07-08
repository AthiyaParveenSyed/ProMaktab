package com.uuq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    // Mapping for the home page
    @GetMapping("/")
    public String homePage(HttpSession session) {
        return "index";
    }
    @GetMapping("/Courses/beginner")
    public String showBeginnerCourse() {
        return "beginner";  
    }

    @GetMapping("/Courses/intermediate")
    public String showIntermediateCourse() {
        return "intermediate"; 
    }

    @GetMapping("/Courses/proficient")
    public String showProficientCourse() {
        return "proficient"; 
    }

    @GetMapping("/Courses/expert")
    public String showExpertCourse() {
        return "expert";  
    }
    @GetMapping("/whyus")
    public String showWhyUsPage() {
        return "whyus";  
    }
    @GetMapping("/pricing")
    public String showPricingPage() {
        return "pricing";  
    }
}
