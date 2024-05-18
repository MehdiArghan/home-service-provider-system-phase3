package com.example.homeserviceprovidersystem.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CustomerSummaryRequest {
    String firstName;
    String lastName;
    String email;
}
