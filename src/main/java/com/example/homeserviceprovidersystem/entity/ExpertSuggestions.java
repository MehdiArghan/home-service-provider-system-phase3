package com.example.homeserviceprovidersystem.entity;

import com.example.homeserviceprovidersystem.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ExpertSuggestions extends BaseEntity<Long> {
    double ProposedPrice;
    LocalDate offerDate;
    LocalTime offerTime;
    LocalTime TimeOfStartWork;
    LocalDate DateOfStartWork;
    Integer durationOfWorkPerHour;
    @ManyToOne
    Orders orders;
    @ManyToOne
    Expert expert;
}
