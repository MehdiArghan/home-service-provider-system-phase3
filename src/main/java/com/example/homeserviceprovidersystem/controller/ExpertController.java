package com.example.homeserviceprovidersystem.controller;

import com.example.homeserviceprovidersystem.dto.expert.ExpertRequest;
import com.example.homeserviceprovidersystem.dto.expert.ExpertSummaryResponse;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsResponse;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsSummaryRequest;
import com.example.homeserviceprovidersystem.dto.order.OrdersResponse;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyRequestWithName;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyResponse;
import com.example.homeserviceprovidersystem.service.ExpertService;
import com.example.homeserviceprovidersystem.service.ExpertSuggestionsService;
import com.example.homeserviceprovidersystem.service.OrdersService;
import com.example.homeserviceprovidersystem.service.SubDutyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/expert")
public class ExpertController {
    final SubDutyService subDutyService;
    final ExpertService expertService;
    final OrdersService ordersService;
    final ExpertSuggestionsService expertSuggestionsService;

    @PostMapping("/addExpert")
    public ResponseEntity<ExpertSummaryResponse> saveExpert(
            @RequestParam("subDutyName") String subDutyName,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("picture") MultipartFile multipartFile
    ) {
        ExpertSummaryResponse savedExpert =
                expertService.save(multipartFile, new ExpertRequest(subDutyName, firstName, lastName, email, password));
        return new ResponseEntity<>(savedExpert, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addExpertSuggestion")
    public ResponseEntity<ExpertSuggestionsResponse> saveExpertSuggestion(@Valid @RequestBody ExpertSuggestionsSummaryRequest request) {
        return new ResponseEntity<>(expertSuggestionsService.save(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/findAllSubDuty")
    public ResponseEntity<List<SubDutyResponse>> findAllSubDuty() {
        return new ResponseEntity<>(subDutyService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/findAllOrders")
    public ResponseEntity<List<OrdersResponse>> findAllOrders(@Valid @RequestBody SubDutyRequestWithName request) {
        return new ResponseEntity<>(ordersService.findAllOrderWaitingForSpecialistSuggestion(request), HttpStatus.OK);
    }
}
