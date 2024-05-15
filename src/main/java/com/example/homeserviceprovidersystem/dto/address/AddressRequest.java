package com.example.homeserviceprovidersystem.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class AddressRequest {
    @NotBlank(message = "Please enter the name of your province")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "province must contain only letters")
    String province;
    @NotBlank(message = "Please enter the name of your city")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "city must contain only letters")
    String city;
    @NotBlank(message = "Please enter the name of your street")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "street must contain only letters")
    String street;
    @NotBlank(message = "Please enter your postalCode")
    String postalCode;
}
