package com.example.homeserviceprovidersystem.dto.subduty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubDutyRequestWithName {
    @NotBlank(message = "please enter the appropriate nameSubDuty")
    @Pattern(regexp = "[a-zA-Z]+", message = "nameSubDuty must contain only letters")
    String nameSubDuty;
}
