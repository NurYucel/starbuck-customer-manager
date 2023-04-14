package com.example.starbuckcustomermanager.business.concretes;

import com.example.starbuckcustomermanager.business.abstracts.CustomerService;
import com.example.starbuckcustomermanager.business.abstracts.CustomerCheckService;
import com.example.starbuckcustomermanager.business.dto.requests.create.CreateCustomerRequest;
import com.example.starbuckcustomermanager.business.dto.response.create.CreateCustomerResponse;
import com.example.starbuckcustomermanager.business.dto.response.get.GetAllCustomersResponse;
import com.example.starbuckcustomermanager.business.dto.response.get.GetCustomerResponse;
import com.example.starbuckcustomermanager.entities.Customer;
import com.example.starbuckcustomermanager.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerCheckService checkService;
    private final ModelMapper mapper;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> response = customers
                .stream()
                .map(customer -> mapper.map(customer, GetAllCustomersResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        checkIfCustomerExists(id);
        Customer customer =repository.findById(id).orElseThrow();
        GetCustomerResponse response = mapper.map(customer, GetCustomerResponse.class);
        return response;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        //checkIfCustomerExists(request);
        Customer customer = mapper.map(request,Customer.class);
        customer.setId(0);
        checkService.checkIfRealPerson(customer);

        repository.save(customer);
        CreateCustomerResponse response = mapper.map(customer, CreateCustomerResponse.class);
        return response;

    }

    @Override
    public void delete(int id) {
        checkIfCustomerExists(id);
        repository.deleteById(id);
    }
    private void checkIfCustomerExists(int id){
        if(!repository.existsById(id)){
            throw  new RuntimeException("");
        }
    }
    private void checkIfCustomerAlreadyExists(String nationalityIdentity){
        for (Customer customer : repository.findAll()) {
            if(customer.getNationalityIdentity().equals(nationalityIdentity))
                throw new RuntimeException("There is already a customer!");
        }
    }
}
