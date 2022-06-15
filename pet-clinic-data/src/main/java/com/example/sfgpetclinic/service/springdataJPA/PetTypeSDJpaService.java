package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.repositories.PetTypeRepository;
import com.example.sfgpetclinic.service.PetTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Slf4j
@Service
@Profile("springdata")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        return new HashSet<>(petTypeRepository.findAll());
    }

    @Override
    public PetType findById(Long petTypeId) {
        return petTypeRepository.findById(petTypeId).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long petTypeId) {
        petTypeRepository.deleteById(petTypeId);
    }
}