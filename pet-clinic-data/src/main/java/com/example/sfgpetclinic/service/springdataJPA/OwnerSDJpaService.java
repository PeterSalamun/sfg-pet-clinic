package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.repositories.OwnerRepository;
import com.example.sfgpetclinic.repositories.PetRepository;
import com.example.sfgpetclinic.repositories.PetTypeRepository;
import com.example.sfgpetclinic.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Slf4j
@Service
@Profile("springdata")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;


    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        return new HashSet<>(ownerRepository.findAll());
    }

    @Override
    public Owner findById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findByLastNameLike(String lastName) {
        return ownerRepository.findByLastNameLike(lastName);
    }
}
