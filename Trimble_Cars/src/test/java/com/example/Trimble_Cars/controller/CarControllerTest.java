package com.example.Trimble_Cars.controller;

import com.example.Trimble_Cars.exception.ResourceNotFoundException;
import com.example.Trimble_Cars.model.Car;
import com.example.Trimble_Cars.repository.ICarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CarControllerTest {
    @Mock
    private ICarRepository carRepository;

    @InjectMocks
    private carController carController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCarDetails_Success() {
        Car car = new Car();
        car.setId(1L);
        car.setModel("Toyota Corolla");
        car.setStatus("Ideal");

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        Optional<Car> result = carController.getCarById(1L);
        assertEquals("Toyota Corolla", result);
    }

    @Test
    void testGetCarDetails_CarNotFound() {
        when(carRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> carController.getCarById(2L));
    }
}
