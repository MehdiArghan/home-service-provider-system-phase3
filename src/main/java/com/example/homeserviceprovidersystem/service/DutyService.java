package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.dto.duty.DutyRequest;
import com.example.homeserviceprovidersystem.dto.duty.DutyResponse;
import com.example.homeserviceprovidersystem.entity.Duty;

import java.util.List;

public interface DutyService {
    DutyResponse save(DutyRequest dutyRequest);

    Duty findByName(String nameDuty);

    List<DutyResponse> findAll();
}
