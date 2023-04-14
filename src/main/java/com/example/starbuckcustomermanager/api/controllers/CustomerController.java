package com.example.starbuckcustomermanager.api.controllers;

import com.example.starbuckcustomermanager.business.abstracts.CustomerService;
import com.example.starbuckcustomermanager.business.dto.requests.create.CreateCustomerRequest;
import com.example.starbuckcustomermanager.business.dto.response.create.CreateCustomerResponse;
import com.example.starbuckcustomermanager.business.dto.response.get.GetAllCustomersResponse;
import com.example.starbuckcustomermanager.business.dto.response.get.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public List<GetAllCustomersResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    public CreateCustomerResponse add(@RequestBody CreateCustomerRequest request){
        return service.add(request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
