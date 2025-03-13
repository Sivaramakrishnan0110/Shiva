package com.example.Trimble_Cars.service.imp;

import com.example.Trimble_Cars.model.Car;
import com.example.Trimble_Cars.model.Lease;
import com.example.Trimble_Cars.repository.ICarRepository;
import com.example.Trimble_Cars.repository.ILeaseRepository;
import com.example.Trimble_Cars.service.ILeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaseService implements ILeaseService {
    @Autowired
    private ILeaseRepository leaseRepository;
    private ICarRepository carRepository;

    @Override
    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }

    @Override
    public Lease createLease(Long carId,String customerId) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("car not found"));
        if (!"ideal".equals(car.getStatus())) {
            throw new RuntimeException("car is not available for lease");
        }
        car.setStatus("on lease");
        Lease lease = new Lease();
        lease.setCarId(carId);
        lease.setCustomerId(customerId);
        lease.setActive(true);
        return leaseRepository.save(lease);
    }

    @Override
    public Lease endLease(Long leaseId) {
        Lease lease = leaseRepository.findById(leaseId).orElseThrow(() -> new RuntimeException("Lease not found"));
        lease.setActive(false);
        leaseRepository.save(lease);

        Car car = carRepository.findById(lease.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setStatus("Ideal");
        carRepository.save(car);

        return lease;
    }

    @Override
    public List<Lease> getLeaseHistory(String customerId) {
        return leaseRepository.findByCustomerId(customerId);
    }
}
