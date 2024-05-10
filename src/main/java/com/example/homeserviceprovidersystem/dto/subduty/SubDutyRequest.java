package com.example.homeserviceprovidersystem.dto.subduty;

import com.example.homeserviceprovidersystem.entity.Duty;
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
public class SubDutyRequest {
    @NotBlank(message = "please enter an appropriate nameDuty")
    @Pattern(regexp = "[a-zA-Z]+", message = "dutyName must contain only letters")
    String nameDuty;
    @NotBlank(message = "please enter an appropriate nameSubDuty")
    @Pattern(regexp = "[a-zA-Z]+", message = "subDutyName must contain only letters")
    String nameSubDuty;
    @NotNull(message = "please enter an appropriate price")
    @Positive(message = "please enter a positive price")
    double basePrice;
    @NotBlank(message = "please enter an appropriate description")
    @Pattern(regexp = "[a-zA-Z]+", message = "description must contain only letters")
    String description;
}
