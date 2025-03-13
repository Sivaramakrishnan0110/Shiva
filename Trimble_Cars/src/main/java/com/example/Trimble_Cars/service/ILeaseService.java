package com.example.Trimble_Cars.service;

import com.example.Trimble_Cars.model.Lease;

import java.util.List;

public interface ILeaseService {
    public List<Lease> getAllLeases();
    public Lease createLease(Long carId,String customerId);
    public Lease endLease(Long leaseId);
    public List<Lease> getLeaseHistory(String customerId);
}
