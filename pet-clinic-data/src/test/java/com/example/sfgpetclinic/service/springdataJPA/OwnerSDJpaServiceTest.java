package com.example.sfgpetclinic.service.springdataJPA;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.repositories.OwnerRepository;
import com.example.sfgpetclinic.repositories.PetRepository;
import com.example.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Doe";
    @InjectMocks
    OwnerSDJpaService service;
    @Mock
    OwnerRepository ownerRepository;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).build();
    }

    @Test
    void findAll() {
        List<Owner> owners = new ArrayList<>();
        owners.add(owner);
        when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(1, ownerRepository.findAll().size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));

        assertNotNull(service.findById(1L));
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        assertNull(service.findById(1L));
    }
    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        assertNotNull(service.save(owner));
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository, times(1)).delete(owner);
    }

    @Test
    void deleteById() {
        service.deleteById(anyLong());
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnOwner);

        Owner doe = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, doe.getLastName());

        verify(ownerRepository, times(1)).findByLastName(any());
    }
}