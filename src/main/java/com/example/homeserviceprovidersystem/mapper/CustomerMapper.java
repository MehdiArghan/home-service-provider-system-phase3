package com.example.homeserviceprovidersystem.mapper;

import com.example.homeserviceprovidersystem.dto.customer.CustomerRequest;
import com.example.homeserviceprovidersystem.dto.customer.CustomerResponse;
import com.example.homeserviceprovidersystem.dto.customer.CustomerSummaryResponse;
import com.example.homeserviceprovidersystem.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    Customer customerRequestTocustomer(CustomerRequest request);
    CustomerResponse customerToCustomerResponse(Customer customer);
    CustomerSummaryResponse customerToCustomerSummaryResponse(Customer customer);
}
