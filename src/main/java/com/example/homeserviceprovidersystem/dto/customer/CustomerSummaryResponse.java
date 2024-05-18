package com.example.homeserviceprovidersystem.dto.customer;

import com.example.homeserviceprovidersystem.dto.person.PersonSummaryResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CustomerSummaryResponse extends PersonSummaryResponse {
}
