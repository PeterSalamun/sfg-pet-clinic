package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"vets", "vets/", "vets/index", "vets/index.html", "/vets.html"})
    public String getListVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
