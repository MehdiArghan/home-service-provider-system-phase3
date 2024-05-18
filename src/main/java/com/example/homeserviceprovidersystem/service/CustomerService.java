package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.dto.customer.CustomerRequest;
import com.example.homeserviceprovidersystem.dto.customer.CustomerResponse;
import com.example.homeserviceprovidersystem.dto.customer.CustomerSummaryRequest;
import com.example.homeserviceprovidersystem.dto.customer.CustomerSummaryResponse;
import com.example.homeserviceprovidersystem.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponse save(CustomerRequest request);

    Customer findById(Long id);

    Customer findByEmail(String email);

    List<CustomerSummaryResponse> findCustomersByDynamicSearch(CustomerSummaryRequest request);
}
