package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetSDJpaService service;

    Pet pet;

    @BeforeEach
    void setUp() {
        pet = Pet.builder().id(1L).name("Rocky").build();
    }

    @Test
    void findAll() {
        List<Pet> pets = new ArrayList<>();
        pets.add(pet);

        when(petRepository.findAll()).thenReturn(pets);

        assertEquals(1, service.findAll().size());
    }

    @Test
    void findById() {
        when(petRepository.findById(any())).thenReturn(Optional.of(pet));
        assertNotNull(service.findById(anyLong()));
        assertEquals(pet.getId(), service.findById(1L).getId());
    }

    @Test
    void findByIdNotFound() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(service.findById(anyLong()));
    }

    @Test
    void save() {
        when(petRepository.save(any())).thenReturn(pet);
        assertEquals(pet, service.save(pet));
    }

    @Test
    void delete() {
        service.delete(pet);
        verify(petRepository, times(1)).delete(pet);
    }

    @Test
    void deleteById() {
        service.deleteById(anyLong());
        verify(petRepository, times(1)).deleteById(anyLong());
    }
}