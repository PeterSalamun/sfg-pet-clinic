package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.model.Visit;
import com.example.sfgpetclinic.service.OwnerService;
import com.example.sfgpetclinic.service.PetService;
import com.example.sfgpetclinic.service.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;


    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;

    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
   public Visit loadPetWithVisit(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);

        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);

        return visit;
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String initCreationForm(@PathVariable Long petId, Model model) {
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processCreationForm(@Valid Visit visit, @PathVariable Long petId, @ModelAttribute Owner owner, BindingResult result){
        if(result.hasErrors()){
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
