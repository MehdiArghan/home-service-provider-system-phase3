package com.example.homeserviceprovidersystem.service.impl;

import com.example.homeserviceprovidersystem.customeException.CustomBadRequestException;
import com.example.homeserviceprovidersystem.customeException.CustomEntityNotFoundException;
import com.example.homeserviceprovidersystem.dto.customer.CustomerRequest;
import com.example.homeserviceprovidersystem.dto.customer.CustomerResponse;
import com.example.homeserviceprovidersystem.entity.Customer;
import com.example.homeserviceprovidersystem.entity.Wallet;
import com.example.homeserviceprovidersystem.mapper.CustomerMapper;
import com.example.homeserviceprovidersystem.repositroy.CustomerRepository;
import com.example.homeserviceprovidersystem.service.CustomerService;
import com.example.homeserviceprovidersystem.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final WalletService walletService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            WalletService walletService,
            CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.walletService = walletService;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse save(CustomerRequest request) {
        customerRepository.findByEmail(request.getEmail()).ifPresent(existingCustomer -> {
            throw new CustomBadRequestException("Email already exists");
        });
        Customer customer = customerMapper.customerRequestTocustomer(request);
        customer.setRegistrationDate(LocalDate.now());
        customer.setRegistrationTime(LocalTime.now());
        customer.setWallet(walletService.save(new Wallet(2000.0)));
        return customerMapper.customerToCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomEntityNotFoundException("customer with this id was not found"));
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() ->new CustomEntityNotFoundException("customer with this email was not found"));
    }
}
