package com.uuq.controller;

import com.uuq.model.User;
import com.uuq.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam String name, 
                                @RequestParam String whatsappNumber, 
                                @RequestParam String password, 
                                Model model) {
        if (userRepository.findByWhatsappNumber(whatsappNumber) != null) {
            model.addAttribute("error", "User already exists!");
            return "signup";
        }

        User user = new User(name, whatsappNumber, password);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String whatsappNumber, 
                               @RequestParam String password, 
                               HttpSession session, 
                               Model model) {
        User user = userRepository.findByWhatsappNumber(whatsappNumber);
        if (user == null || user.getPassword() == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid credentials!");
            return "login";
        }
 
        session.setAttribute("user", user);
        String redirectUrl= (String) session.getAttribute("redirectAfterLogin");
        if(redirectUrl !=null) {
        	session.removeAttribute("redirectAfterLogin");
            return "redirect:" + redirectUrl;

        }
       // System.out.println("User set in session: " + user.getWhatsappNumber());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        System.out.println("Session invalidated successfully.");
        return "redirect:/";
    }
}
