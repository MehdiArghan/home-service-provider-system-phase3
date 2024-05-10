package com.example.homeserviceprovidersystem.dto.person;

import com.example.homeserviceprovidersystem.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class PersonResponse extends BaseEntity<Long> {
    String firstName;
    String lastName;
    String email;
    String password;
    LocalDate registrationDate;
    LocalTime registrationTime;
}
