package com.example.sfgpetclinic.bootstrap;


import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.service.OwnerService;
import com.example.sfgpetclinic.service.PetTypeService;
import com.example.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Weston");

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
