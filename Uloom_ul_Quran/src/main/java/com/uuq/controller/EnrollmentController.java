package com.uuq.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uuq.model.Enrollment;
import com.uuq.model.User;
import com.uuq.repository.EnrollmentRepository;

import org.springframework.ui.Model;

@Controller
public class EnrollmentController {
	@Autowired
    private EnrollmentRepository enrollmentRepository;


    @GetMapping("/enroll")
    public String enrollUser(@RequestParam(required = false) String course, HttpSession session,HttpServletRequest request, Model model) {
        // Check if user is logged in
        User user = (User) session.getAttribute("user");

        if (user == null) {
            // User is not logged in
        	session.setAttribute("redirectAfterLogin", request.getRequestURI() + (request.getQueryString() != null ? "?" + request.getQueryString() : ""));
            return "redirect:/login";
        }
        if (course == null || course.isEmpty()) {
            course = "Unknown";
        }

        // ✅ Check if already enrolled
        Optional<Enrollment> existing = enrollmentRepository
            .findByWhatsappNumberAndCourseName(user.getWhatsappNumber(), course);

        if (existing.isPresent()) {
            // User already enrolled → show error page or info page
            model.addAttribute("userName", user.getName());
            model.addAttribute("course", course);
            model.addAttribute("alreadyEnrolled", true);
            return "enroll-success";
        }
        Enrollment enrollment = new Enrollment(
        		user.getName(),
                user.getWhatsappNumber(),
                course,
                LocalDateTime.now()
            );

            enrollmentRepository.save(enrollment);


        model.addAttribute("userName", user.getName()); // Pass user name to show in success page
        model.addAttribute("course", course);
        model.addAttribute("alreadyEnrolled", false);
        return "enroll-success";  // Return the success page
    }
}
