package com.example.homeserviceprovidersystem.dto.expert;

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
    int score;
}
