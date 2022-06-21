package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Specialty;
import com.example.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialtySDJpaServiceTest {

    @InjectMocks
    SpecialtySDJpaService service;

    @Mock
    SpecialtyRepository specialtyRepository;

    Specialty sp1, sp2;

    @BeforeEach
    void setUp() {
        sp1 = Specialty.builder().id(1L).description("sp1").build();
        sp2 = Specialty.builder().id(2L).description("sp2").build();
    }

    @Test
    void findAll() {
        List<Specialty> specialties = new ArrayList<>();
        specialties.add(sp1);
        specialties.add(sp2);

        when(specialtyRepository.findAll()).thenReturn(specialties);

        assertEquals(specialties.size(), service.findAll().size());
    }

    @Test
    void findById() {
        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(sp1));
        assertEquals(sp1, service.findById(1L));
    }

    @Test
    void findByIdNotFound() {
        when(specialtyRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(service.findById(anyLong()));
    }

    @Test
    void save() {
        when(specialtyRepository.save(sp2)).thenReturn(sp2);
        assertEquals(sp2, service.save(sp2));
    }

    @Test
    void delete() {
        service.delete(sp1);
        verify(specialtyRepository, times(1)).delete(sp1);
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(specialtyRepository,times(1)).deleteById(any());
    }
}