package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Visit;
import com.example.sfgpetclinic.repositories.VisitRepository;
import com.example.sfgpetclinic.service.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Slf4j
@Service
@Profile("springdata")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return new HashSet<>(visitRepository.findAll());
    }

    @Override
    public Visit findById(Long visitId) {
        return visitRepository.findById(visitId).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long visitId) {
        visitRepository.deleteById(visitId);
    }
}
