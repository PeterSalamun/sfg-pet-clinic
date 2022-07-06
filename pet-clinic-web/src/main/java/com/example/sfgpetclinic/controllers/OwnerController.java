package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"/owners", "/owners/", "/owners/index", "/owners/index.html"})
    public String getOwnersList(Model model) {

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @GetMapping("/owners/find")
    public String findOnwers(){
        return "notImplemented";
    }

    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(this.ownerService.findById(ownerId));
        return modelAndView;
    }
}
