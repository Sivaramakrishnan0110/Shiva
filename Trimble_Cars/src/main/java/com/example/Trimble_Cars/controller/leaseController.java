package com.example.Trimble_Cars.controller;

import com.example.Trimble_Cars.model.Lease;
import com.example.Trimble_Cars.service.ILeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leases")
public class leaseController {
    @Autowired
    private ILeaseService leaseService;

    @GetMapping
    public List<Lease> getAllLeases() {
        return leaseService.getAllLeases();
    }


    @PostMapping("/start")
    public Lease createLease(@RequestParam Long carId, @RequestParam String customerId) {
        return leaseService.createLease(carId,customerId);
    }

    @PostMapping("/end")
    public Lease endLease(@RequestParam Long leaseId) {
        return leaseService.endLease(leaseId);

    }

    @GetMapping("/history")
    public List<Lease> getLeaseHistory(@RequestParam String customerId) {
        return leaseService.getLeaseHistory(customerId);
    }
}

