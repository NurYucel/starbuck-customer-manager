package com.example.starbuckcustomermanager.business.abstracts;

import com.example.starbuckcustomermanager.business.dto.requests.create.CreateCustomerRequest;

import com.example.starbuckcustomermanager.business.dto.response.create.CreateCustomerResponse;
import com.example.starbuckcustomermanager.business.dto.response.get.GetAllCustomersResponse;
import com.example.starbuckcustomermanager.business.dto.response.get.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    GetCustomerResponse getById(int id);
    CreateCustomerResponse add(CreateCustomerRequest request);
    void delete(int id);
}
