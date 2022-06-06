package com.example.sfgpetclinic.bootstrap;


import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.service.OwnerService;
import com.example.sfgpetclinic.service.PetTypeService;
import com.example.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

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

        ownerService.save(owner2);
        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setLastName("Axe");
        vet1.setFirstName("Sam");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Martha");
        vet2.setLastName("Axe");

        vetService.save(vet2);
        System.out.println("Loaded vets...");
    }
}
