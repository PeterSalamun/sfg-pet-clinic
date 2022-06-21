package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class PetTypeSDJpaServiceTest {
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    PetTypeSDJpaService service;

    PetType cat;
    PetType dog;

    @BeforeEach
    void setUp() {
        cat = PetType.builder().name("cat").id(1L).build();
        dog =  PetType.builder().name("dog").id(2L).build();
    }

    @Test
    void findAll() {
        List<PetType> types = new ArrayList<>();
        types.add(dog);
        types.add(cat);

        when(petTypeRepository.findAll()).thenReturn(types);

        assertEquals(types.size(), service.findAll().size());
    }

    @Test
    void findById() {
        when(petTypeRepository.findById(2L)).thenReturn(Optional.of(dog));
        assertEquals(dog.getId(), service.findById(2L).getId());
    }

    @Test
    void save() {
        when(petTypeRepository.save(any())).thenReturn(dog);
        assertNotNull(service.save(dog));
    }

    @Test
    void delete() {
        service.delete(dog);
        verify(petTypeRepository, times(1)).delete(dog);
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(petTypeRepository, times(1)).deleteById(1L);
    }
}