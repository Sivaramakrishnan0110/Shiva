package com.example.Trimble_Cars.service.imp;

import com.example.Trimble_Cars.exception.BadRequestException;
import com.example.Trimble_Cars.exception.ResourceNotFoundException;
import com.example.Trimble_Cars.model.Car;
import com.example.Trimble_Cars.model.Lease;
import com.example.Trimble_Cars.repository.ICarRepository;
import com.example.Trimble_Cars.repository.ILeaseRepository;
import com.example.Trimble_Cars.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository carRepository;
    private ILeaseRepository leaseRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return Optional.ofNullable(carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with ID: " + id)));
    }

    @Override
    public Car addCar(Car car) {
        if (car.getModel() == null || car.getModel().isEmpty()) {
            throw new BadRequestException("Car model cannot be empty.");
        }
        car.setStatus("ideal");
        return carRepository.save(car);
    }

    @Override
    public List<Lease> getCarHistory(Long carId) {
        return leaseRepository.findByCarId(carId);
    }
}
