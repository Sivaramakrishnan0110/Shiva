package com.example.Trimble_Cars.repository;

import com.example.Trimble_Cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<Car,Long> {
}
