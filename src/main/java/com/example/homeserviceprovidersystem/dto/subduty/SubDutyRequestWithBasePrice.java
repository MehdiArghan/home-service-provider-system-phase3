package com.example.homeserviceprovidersystem.dto.subduty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubDutyRequestWithBasePrice {
    @NotBlank(message = "please enter the appropriate nameSubDuty")
    @Pattern(regexp = "[a-zA-Z]+", message = "nameSubDuty must contain only letters")
    String nameSubDuty;
    @NotNull(message = "please enter the appropriate price")
    @Positive(message = "please enter a positive price")
    double basePrice;
}
