package com.example.homeserviceprovidersystem.repositroy;

import com.example.homeserviceprovidersystem.entity.Expert;
import com.example.homeserviceprovidersystem.entity.enums.ExpertStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long>, JpaSpecificationExecutor<Expert> {
    Optional<Expert> findByEmail(String Email);

    List<Expert> findAllByExpertStatus(ExpertStatus expertStatus);
}
