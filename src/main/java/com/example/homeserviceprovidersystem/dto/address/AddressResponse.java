package com.example.homeserviceprovidersystem.dto.address;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class AddressResponse {
    String province;
    String city;
    String street;
    String postalCode;
}
