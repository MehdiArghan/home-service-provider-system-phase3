package com.example.homeserviceprovidersystem.dto.duty;

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
public class DutyRequest {
    @NotBlank(message = "please enter the appropriate name")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "dutyName must contain only letters")
    String name;
}
