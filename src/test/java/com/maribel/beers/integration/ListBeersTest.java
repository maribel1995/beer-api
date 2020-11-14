package com.maribel.beers.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maribel.beers.entity.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ListBeersTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getBeers() throws Exception {
        mockMvc.perform(get("/v1/beers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("Madalena Weiss"))
                .andExpect(jsonPath("$.[1].name").value("Madalena Session Ipa"))
                .andExpect(jsonPath("$.[2].name").value("Colorado Ribeirão"));
    }

    @Test
    public void addBeer() throws Exception {
        Beer beer = new Beer("Skoll", "Pielsen");
        mockMvc.perform(post("/v1/beers").contentType("application/json").content(objectMapper.writeValueAsString(beer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Skoll"));
    }
}
