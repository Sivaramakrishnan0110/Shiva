package com.example.Trimble_Cars.controller;

import com.example.Trimble_Cars.model.Car;
import com.example.Trimble_Cars.model.Lease;
import com.example.Trimble_Cars.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class carController {
    @Autowired
    private ICarService carService;

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }
    @PostMapping
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }
    @GetMapping("/{carId}/history")
    public List<Lease> getCarHistory(@PathVariable Long carId) {
        return carService.getCarHistory(carId);
    }
    @GetMapping(value = "/{carId}")
    public Optional<Car> getCarById(@PathVariable Long Id){
        return carService.getCarById(Id);
    }
}
