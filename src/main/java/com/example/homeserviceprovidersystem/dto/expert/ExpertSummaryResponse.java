package com.example.homeserviceprovidersystem.dto.expert;

import com.example.homeserviceprovidersystem.dto.person.PersonSummaryResponse;
import com.example.homeserviceprovidersystem.entity.SubDuty;
import com.example.homeserviceprovidersystem.entity.enums.ExpertStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ExpertSummaryResponse extends PersonSummaryResponse {
    @Enumerated(EnumType.STRING)
    ExpertStatus expertStatus;
    String pictureData;
    int score;
    Set<SubDuty> subDuties;
}
