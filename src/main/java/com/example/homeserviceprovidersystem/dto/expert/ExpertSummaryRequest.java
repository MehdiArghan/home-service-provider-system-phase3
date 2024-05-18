package com.example.homeserviceprovidersystem.dto.expert;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ExpertSummaryRequest {
    String subDutyName;
    String firstName;
    String lastName;
    String email;
    @Pattern(regexp = "^$|^[+-]?\\d+$", message = "Please enter the correct score")
    String score;
}
