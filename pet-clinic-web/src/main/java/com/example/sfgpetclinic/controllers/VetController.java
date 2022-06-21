package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.service.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/", "/index", "/index.html", "/vets.html"})
    public String getListVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
