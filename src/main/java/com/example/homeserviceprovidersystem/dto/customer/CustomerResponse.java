package com.example.homeserviceprovidersystem.dto.customer;

import com.example.homeserviceprovidersystem.dto.person.PersonResponse;
import com.example.homeserviceprovidersystem.entity.Wallet;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CustomerResponse extends PersonResponse {
    Wallet wallet;
}
