package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    private final OwnerService ownerService;

    @GetMapping({"", "/", "/index", "/index.html"})
    public String getOwnersList(Model model) {

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
