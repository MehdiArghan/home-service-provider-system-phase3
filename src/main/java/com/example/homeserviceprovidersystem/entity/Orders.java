package com.example.homeserviceprovidersystem.entity;

import com.example.homeserviceprovidersystem.base.BaseEntity;
import com.example.homeserviceprovidersystem.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Orders extends BaseEntity<Long> {
    double ProposedPrice;
    String jobDescription;
    LocalDate dateOfWork;
    LocalTime TimeOfWord;
    @Embedded
    Address address;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
    @ManyToOne
    Customer customer;
    @ManyToOne
    Expert expert;
    @ManyToOne
    SubDuty subDuty;

    public Orders(double proposedPrice, String jobDescription, LocalDate dateOfWork, LocalTime timeOfWord, Address address) {
        ProposedPrice = proposedPrice;
        this.jobDescription = jobDescription;
        this.dateOfWork = dateOfWork;
        TimeOfWord = timeOfWord;
        this.address = address;
    }
}
