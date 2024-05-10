package com.example.homeserviceprovidersystem.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class Address {
    String province;
    String city;
    String street;
    String postalCode;
}
