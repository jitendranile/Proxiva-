package com.proxiva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proxiva.model.User;
import com.proxiva.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {

        User savedUser = userService.registerUser(user);

        if (savedUser == null) {
            model.addAttribute("error", "Email already registered. Please login.");
            return "register";
        }

        model.addAttribute("success", "Registration successful. Please login.");
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        User user = userService.loginUser(email, password);

        if (user != null) {

            session.setAttribute("loggedInUser", user);

            if (user.getRole().equalsIgnoreCase("provider")) {
                return "redirect:/provider/dashboard";
            } else {
                return "redirect:/dashboard";
            }
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}