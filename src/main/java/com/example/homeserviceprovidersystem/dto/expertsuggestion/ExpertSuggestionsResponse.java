package com.example.homeserviceprovidersystem.dto.expertsuggestion;

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
public class ExpertSuggestionsResponse extends BaseEntity<Long> {
    LocalDate offerDate;
    LocalTime offerTime;
    double ProposedPrice;
    LocalDate DateOfStartWork;
    LocalTime TimeOfStartWork;
    Integer durationOfWorkPerHour;
    String nameSubDuty;
}
