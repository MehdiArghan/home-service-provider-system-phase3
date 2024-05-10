package com.example.homeserviceprovidersystem.service.impl;

import com.example.homeserviceprovidersystem.customeException.CustomBadRequestException;
import com.example.homeserviceprovidersystem.customeException.CustomEntityNotFoundException;
import com.example.homeserviceprovidersystem.customeException.CustomResourceNotFoundException;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyRequest;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyRequestWithBasePrice;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyRequestWithDescription;
import com.example.homeserviceprovidersystem.dto.subduty.SubDutyResponse;
import com.example.homeserviceprovidersystem.entity.Duty;
import com.example.homeserviceprovidersystem.entity.SubDuty;
import com.example.homeserviceprovidersystem.mapper.SubDutyMapper;
import com.example.homeserviceprovidersystem.repositroy.SubDutyRepository;
import com.example.homeserviceprovidersystem.service.DutyService;
import com.example.homeserviceprovidersystem.service.SubDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubDutyServiceImpl implements SubDutyService {
    private final SubDutyRepository subDutyRepository;
    private final DutyService dutyService;
    private final SubDutyMapper subDutyMapper;

    @Autowired
    public SubDutyServiceImpl(
            SubDutyRepository subDutyRepository,
            DutyService dutyService,
            SubDutyMapper subDutyMapper) {
        this.subDutyRepository = subDutyRepository;
        this.dutyService = dutyService;
        this.subDutyMapper = subDutyMapper;
    }

    @Override
    public SubDutyResponse save(SubDutyRequest subDutyRequest) {
        Optional<SubDuty> foundSubDuty = subDutyRepository.findByName(subDutyRequest.getNameSubDuty());
        Duty duty = dutyService.findByName(subDutyRequest.getNameDuty());
        if (foundSubDuty.isEmpty()) {
            SubDuty subDuty = new SubDuty(
                    subDutyRequest.getNameSubDuty(),
                    subDutyRequest.getBasePrice(),
                    subDutyRequest.getDescription(),
                    duty);
            return subDutyMapper.subDutyToSubDutyResponse(subDutyRepository.save(subDuty));
        } else {
            throw new CustomBadRequestException("the subDuty is available");
        }
    }

    @Override
    public SubDutyResponse updateDescription(SubDutyRequestWithDescription request) {
        Optional<SubDuty> foundSubDuty = subDutyRepository.findByName(request.getNameSubDuty());
        if (foundSubDuty.isEmpty()) {
            throw new CustomEntityNotFoundException("no subDuty was found with this id");
        } else {
            SubDuty existSubDuty = foundSubDuty.get();
            existSubDuty.setDescription(request.getDescription());
            return subDutyMapper.subDutyToSubDutyResponse(subDutyRepository.save(existSubDuty));
        }
    }

    @Override
    public SubDutyResponse updateBasePrice(SubDutyRequestWithBasePrice request) {
        Optional<SubDuty> foundSubDuty = subDutyRepository.findByName(request.getNameSubDuty());
        if (foundSubDuty.isEmpty()) {
            throw new CustomEntityNotFoundException("no subDuty was found with this id");
        } else {
            SubDuty existSubDuty = foundSubDuty.get();
            existSubDuty.setBasePrice(request.getBasePrice());
            return subDutyMapper.subDutyToSubDutyResponse(subDutyRepository.save(existSubDuty));
        }
    }

    @Override
    public SubDuty findById(Long id) {
        Optional<SubDuty> foundSubDuty = subDutyRepository.findById(id);
        if (foundSubDuty.isEmpty()) {
            throw new CustomEntityNotFoundException("no subDuty was found with this id");
        } else {
            return foundSubDuty.get();
        }
    }

    @Override
    public SubDuty findByName(String name) {
        return subDutyRepository.findByName(name)
                .orElseThrow(() -> new CustomEntityNotFoundException("no subDuty was found with this name"));
    }

    @Override
    public List<SubDutyResponse> findAll() {
        List<SubDuty> subDutyList = subDutyRepository.findAll();
        if (subDutyList.isEmpty()) {
            throw new CustomResourceNotFoundException("There is no result");
        } else {
            return subDutyList.stream().map(subDutyMapper::subDutyToSubDutyResponse).toList();
        }
    }
}
