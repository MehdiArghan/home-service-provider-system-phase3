package com.example.homeserviceprovidersystem.mapper;

import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsResponse;
import com.example.homeserviceprovidersystem.entity.ExpertSuggestions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExpertSuggestionsMapper {
    @Mapping(source = "orders.subDuty.name", target = "nameSubDuty")
    ExpertSuggestionsResponse expertSuggestionToExpertSuggestionsResponse(ExpertSuggestions expertSuggestions);
}
