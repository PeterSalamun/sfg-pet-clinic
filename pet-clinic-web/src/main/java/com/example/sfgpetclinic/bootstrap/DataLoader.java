package com.example.sfgpetclinic.bootstrap;


import com.example.sfgpetclinic.model.*;
import com.example.sfgpetclinic.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    private final SpecialtyService specialtyService;

    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123-123-132");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Bella");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Weston");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123-123-132");

        Pet fionaPet = new Pet();
        fionaPet.setPetType(savedCatType);
        fionaPet.setOwner(owner2);
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setName("Rosco");
        owner2.getPets().add(fionaPet);

        Pet.builder().id(1L).build();

        PetType.builder().id(1L);
        ownerService.save(owner2);

        Visit visit1 = new Visit();
        visit1.setPet(fionaPet);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sneezy kitty");

        visitService.save(visit1);

        System.out.println("Loaded Owners ...");

        Specialty spec1 = new Specialty();
        spec1.setDescription("radiology");
        Specialty radiology = specialtyService.save(spec1);

        Specialty spec2 = new Specialty();
        spec2.setDescription("surgery");
        Specialty surgery = specialtyService.save(spec2);

        Specialty spec3 = new Specialty();
        spec3.setDescription("dentistry");
        Specialty dentistry = specialtyService.save(spec3);

        Vet vet1 = new Vet();
        vet1.setLastName("Axe");
        vet1.setFirstName("Sam");
        vet1.getSpecialties().add(radiology);
        vet1.getSpecialties().add(dentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Martha");
        vet2.setLastName("Axe");
        vet2.getSpecialties().add(surgery);

        vetService.save(vet2);
        System.out.println("Loaded vets...");
    }
}
