package com.example.starbuckcustomermanager.business.abstracts;

import com.example.starbuckcustomermanager.entities.Customer;

public interface CustomerCheckService {
    boolean checkIfRealPerson(Customer customer);
}
