package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.repositories.VetRepository;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @InjectMocks
    VetSDJpaService service;
    @Mock
    VetRepository repository;

    Vet vet1, vet2;

    @BeforeEach
    void setUp() {
        vet1 = Vet.builder().id(1L).firstName("John").build();
        vet2 = Vet.builder().id(2L).firstName("Jessie").build();
    }

    @Test
    void findAll() {
        List<Vet> vets = new ArrayList<>();
        vets.add(vet1);
        vets.add(vet2);

        when(repository.findAll()).thenReturn(vets);

        assertEquals(vets.size(), service.findAll().size());
    }

    @Test
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.of(vet1));
        assertNotNull(service.findById(1L));
        assertEquals(vet1, service.findById(1L));
    }

    @Test
    void findByIdNotFound() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(service.findById(anyLong()));
    }

    @Test
    void save() {
        when(repository.save(vet2)).thenReturn(vet2);
        assertEquals(vet2, service.save(vet2));
    }

    @Test
    void delete() {
        service.delete(vet1);
        verify(repository, times(1)).delete(vet1);
    }

    @Test
    void deleteById() {
        service.deleteById(2L);
        verify(repository, times(1)).deleteById(2L);
    }
}