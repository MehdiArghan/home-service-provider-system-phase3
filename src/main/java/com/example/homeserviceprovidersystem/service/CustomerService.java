package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.dto.customer.CustomerRequest;
import com.example.homeserviceprovidersystem.dto.customer.CustomerResponse;
import com.example.homeserviceprovidersystem.entity.Customer;

public interface CustomerService {
    CustomerResponse save(CustomerRequest request);

    Customer findById(Long id);

    Customer findByEmail(String email);
}
