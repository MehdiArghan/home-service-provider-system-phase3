package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.dto.expert.ExpertRequest;
import com.example.homeserviceprovidersystem.dto.expert.ExpertRequestWithEmail;
import com.example.homeserviceprovidersystem.dto.expert.ExpertSummaryRequest;
import com.example.homeserviceprovidersystem.dto.expert.ExpertSummaryResponse;
import com.example.homeserviceprovidersystem.entity.Expert;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExpertService {
    ExpertSummaryResponse save(MultipartFile multipartFile, ExpertRequest request);

    Expert save(Expert expert);

    ExpertSummaryResponse expertConfirmation(ExpertRequestWithEmail request);

    Expert findById(Long id);

    Expert findByEmail(String email);

    List<ExpertSummaryResponse> findAllDisableExperts();

    List<ExpertSummaryResponse> findAll();

    List<ExpertSummaryResponse> findExpertsByDynamicSearch(ExpertSummaryRequest request);
}
