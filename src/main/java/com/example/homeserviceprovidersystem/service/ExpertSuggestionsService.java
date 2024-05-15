package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsRequest;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsRequestWithId;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsResponse;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsSummaryRequest;
import com.example.homeserviceprovidersystem.entity.ExpertSuggestions;

import java.util.List;

public interface ExpertSuggestionsService {
    ExpertSuggestionsResponse save(ExpertSuggestionsSummaryRequest request);

    List<ExpertSuggestionsResponse> findAllOrderSuggestions(ExpertSuggestionsRequest request);

    ExpertSuggestions findById(Long id);

    ExpertSuggestions findByExpertEmailAndOrderId(String expertEmail,Long orderId);

    ExpertSuggestionsResponse selectExpertSuggestion(ExpertSuggestionsRequestWithId request);
}
