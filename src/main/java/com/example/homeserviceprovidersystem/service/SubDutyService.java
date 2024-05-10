package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.dto.subduty.SubDutyRequest;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyRequestWithBasePrice;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyRequestWithDescription;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyResponse;
import com.example.homeserviceprovidersystem.entity.SubDuty;

import java.util.List;

public interface SubDutyService {
    SubDutyResponse save(SubDutyRequest subDutyRequest);

    SubDutyResponse updateDescription(SubDutyRequestWithDescription request);

    SubDutyResponse updateBasePrice(SubDutyRequestWithBasePrice request);

    SubDuty findById(Long id);

    SubDuty findByName(String name);

    List<SubDutyResponse> findAll();
}
