package com.example.Trimble_Cars.repository;

import com.example.Trimble_Cars.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILeaseRepository extends JpaRepository<Lease,Long> {
    List<Lease> findByCustomerId(String customerId);

    List<Lease> findByCarId(Long carId);
}
