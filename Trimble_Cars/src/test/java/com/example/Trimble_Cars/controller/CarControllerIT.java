package com.example.Trimble_Cars.controller;

import com.example.Trimble_Cars.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(carController.class)
public class CarControllerIT {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Test
    void testRegisterCar() throws Exception {
        Car car = new Car();
        car.setModel("Honda Civic");
        car.setStatus("Ideal");

        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(car)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("Honda Civic"));
    }
}
