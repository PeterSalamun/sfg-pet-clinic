package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Visit;
import com.example.sfgpetclinic.repositories.VisitRepository;
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
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService service;

    Visit v1, v2;

    @BeforeEach
    void setUp() {
        v1 = Visit.builder().id(1L).build();
        v2 = Visit.builder().id(2L).build();
    }

    @Test
    void findAll() {
        List<Visit> visits = new ArrayList<>();
        visits.add(v1);
        visits.add(v2);

        when(repository.findAll()).thenReturn(visits);

        assertEquals(visits.size(), service.findAll().size());
    }

    @Test
    void findById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(v1));
        assertNotNull(service.findById(anyLong()));
        assertEquals(v1, service.findById(anyLong()));
    }

    @Test
    void findByIdNotFound() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(service.findById(anyLong()));
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(v1);
        assertEquals(v1, service.save(any()));
    }

    @Test
    void delete() {
        service.delete(v1);
        verify(repository, times(1)).delete(v1);
    }

    @Test
    void deleteById() {
        service.deleteById(anyLong());
        verify(repository, times(1)).deleteById(anyLong());
    }
}