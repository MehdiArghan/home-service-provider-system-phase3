package com.example.homeserviceprovidersystem.entity;

import com.example.homeserviceprovidersystem.entity.enums.ExpertStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Expert extends Person {
    @Enumerated(EnumType.STRING)
    ExpertStatus expertStatus;
    String pictureData;
    int score;
    @ManyToMany
    @JoinTable(
            name = "Expert_SubDuty",
            joinColumns = @JoinColumn(name = "Expert_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "SubDuty_id", referencedColumnName = "id")
    )
    Set<SubDuty> subDuties;
    @OneToOne
    Wallet wallet;
}
