package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.service.VetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @InjectMocks
    VetController controller;

    @Mock
    VetService service;

    Set<Vet> vets;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        vets = new HashSet<>();
        vets.add(Vet.builder().id(1L).build());
        vets.add(Vet.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @ParameterizedTest(name = "{index}. test with path: \"{arguments}\"")
    @ValueSource(strings = {"/vets", "/vets/", "/vets/index", "/vets/index.html", "/vets/vets.html"})
    void getListVets(String input) throws Exception {

        when(service.findAll()).thenReturn(vets);

        mockMvc.perform(get(input



                ))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets", hasSize(2)));

    }
}