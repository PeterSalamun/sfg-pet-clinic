package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.repositories.VetRepository;
import com.example.sfgpetclinic.service.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Slf4j
@Service
@Profile("springdata")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Set<Vet> findAll() {
        return new HashSet<>(vetRepository.findAll());
    }

    @Override
    public Vet findById(Long vetId) {
        return vetRepository.findById(vetId).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long vetId) {
        vetRepository.deleteById(vetId);
    }
}
