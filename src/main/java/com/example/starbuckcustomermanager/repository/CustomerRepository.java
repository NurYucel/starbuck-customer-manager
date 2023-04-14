package com.example.starbuckcustomermanager.repository;

import com.example.starbuckcustomermanager.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
