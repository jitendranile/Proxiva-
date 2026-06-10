package com.proxiva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proxiva.model.ServiceEntity;
import com.proxiva.model.User;
import com.proxiva.service.ServiceService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/dashboard")
    public String customerDashboard(Model model,
                                    HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        model.addAttribute("user", user);
        model.addAttribute("services", serviceService.getAllServices());

        return "dashboard";
    }

    @GetMapping("/services")
    public String servicesPage(Model model,
                               HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        model.addAttribute("user", user);
        model.addAttribute("services", serviceService.getAllServices());

        return "services";
    }

    @GetMapping("/provider/dashboard")
    public String providerDashboard(Model model,
                                    HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        model.addAttribute("user", user);
        model.addAttribute("services", serviceService.getAllServices());

        return "provider-dashboard";
    }

    @GetMapping("/add-service")
    public String addServicePage() {
        return "add-service";
    }

    @PostMapping("/add-service")
    public String addService(@ModelAttribute ServiceEntity service) {
        serviceService.addService(service);
        return "redirect:/provider/dashboard";
    }
}