package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Specialty;
import com.example.sfgpetclinic.repositories.SpecialtyRepository;
import com.example.sfgpetclinic.service.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

public class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        return new HashSet<>(specialtyRepository.findAll());
    }

    @Override
    public Specialty findById(Long specialtyId) {
        return specialtyRepository.findById(specialtyId).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long specialtyId) {
        specialtyRepository.deleteById(specialtyId);
    }
}