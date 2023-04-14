package com.example.starbuckcustomermanager.business.concretes;

import com.example.starbuckcustomermanager.business.abstracts.CustomerCheckService;
import com.example.starbuckcustomermanager.entities.Customer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerCheckManager implements CustomerCheckService {
    private final CustomerCheckService service;
    @Override
    public boolean checkIfRealPerson(Customer customer) {
        return service.checkIfRealPerson(customer);
    }
}
