package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.repositories.PetRepository;
import com.example.sfgpetclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdata")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        return new HashSet<>(petRepository.findAll());
    }

    @Override
    public Pet findById(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long petId) {
        petRepository.deleteById(petId);
    }
}
