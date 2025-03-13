package com.example.Trimble_Cars.service;

import com.example.Trimble_Cars.exception.ResourceNotFoundException;
import com.example.Trimble_Cars.model.Car;
import com.example.Trimble_Cars.repository.ICarRepository;
import com.example.Trimble_Cars.service.imp.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CarServiceTest {
    @Mock
    private ICarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindCarById_Success() {
        Car car = new Car();
        car.setId(1L);
        car.setModel("Nissan Altima");
        car.setStatus("On Lease");

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        Optional<Car> result = carService.getCarById(1L);
        assertEquals("Nissan Altima", result.getClass());
    }

    @Test
    void testFindCarById_CarNotFound() {
        when(carRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> carService.getCarById(2L));
    }
}
