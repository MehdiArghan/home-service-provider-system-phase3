package com.example.homeserviceprovidersystem.repositroy;

import com.example.homeserviceprovidersystem.entity.SubDuty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubDutyRepository extends JpaRepository<SubDuty, Long> {
    Optional<SubDuty> findByName(String nameSubDuty);
}
