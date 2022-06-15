package com.example.sfgpetclinic.service;

import com.example.sfgpetclinic.model.Visit;

import java.util.Set;

public interface VisitService extends CrudService<Visit, Long> {
    @Override
    default Set<Visit> findAll() {
        return null;
    }

    @Override
    default Visit findById(Long visitId) {
        return null;
    }

    @Override
    default Visit save(Visit visit) {
        return null;
    }

    @Override
    default void delete(Visit visit) {

    }

    @Override
    default void deleteById(Long visitId) {

    }
}
