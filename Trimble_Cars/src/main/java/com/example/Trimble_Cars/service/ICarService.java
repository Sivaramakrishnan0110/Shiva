package com.example.Trimble_Cars.service;

import com.example.Trimble_Cars.model.Car;
import com.example.Trimble_Cars.model.Lease;
import com.example.Trimble_Cars.repository.ILeaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    public List<Car> getAllCars();
    public Optional<Car> getCarById(Long id);
    public Car addCar(Car car);
    public List<Lease> getCarHistory(Long carId);
}
