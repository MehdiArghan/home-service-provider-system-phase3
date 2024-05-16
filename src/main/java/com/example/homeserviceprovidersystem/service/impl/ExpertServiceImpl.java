package com.example.homeserviceprovidersystem.service.impl;

import com.example.homeserviceprovidersystem.customeException.CustomBadRequestException;
import com.example.homeserviceprovidersystem.customeException.CustomEntityNotFoundException;
import com.example.homeserviceprovidersystem.customeException.CustomResourceNotFoundException;
import com.example.homeserviceprovidersystem.dto.expert.ExpertRequest;
import com.example.homeserviceprovidersystem.dto.expert.ExpertRequestWithEmail;
import com.example.homeserviceprovidersystem.dto.expert.ExpertSummaryResponse;
import com.example.homeserviceprovidersystem.entity.Expert;
import com.example.homeserviceprovidersystem.entity.SubDuty;
import com.example.homeserviceprovidersystem.entity.Wallet;
import com.example.homeserviceprovidersystem.entity.enums.ExpertStatus;
import com.example.homeserviceprovidersystem.mapper.ExpertMapper;
import com.example.homeserviceprovidersystem.repositroy.ExpertRepository;
import com.example.homeserviceprovidersystem.service.ExpertService;
import com.example.homeserviceprovidersystem.service.SubDutyService;
import com.example.homeserviceprovidersystem.service.WalletService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ExpertServiceImpl implements ExpertService {
    private final SubDutyService subDutyService;
    private final ExpertRepository expertRepository;
    private final WalletService walletService;
    private final ExpertMapper expertMapper;
    private final Validator validator;

    @Autowired
    public ExpertServiceImpl(
            SubDutyService subDutyService,
            ExpertRepository expertRepository,
            WalletService walletService,
            ExpertMapper expertMapper,
            Validator validator) {
        this.subDutyService = subDutyService;
        this.expertRepository = expertRepository;
        this.walletService = walletService;
        this.expertMapper = expertMapper;
        this.validator = validator;
    }

    @Override
    public ExpertSummaryResponse save(MultipartFile multipartFile, ExpertRequest request) {
        validateRequest(request);
        validateMultiPartFile(multipartFile);
        expertRepository.findByEmail(request.getEmail()).ifPresent(existingExpert -> {
            throw new CustomBadRequestException("Email already exists");
        });
        Expert expert = createExpert(multipartFile, request);
        Expert savedExpert = expertRepository.save(expert);
        return expertMapper.expertToExpertSummaryResponse(savedExpert);
    }

    @Override
    public Expert save(Expert expert) {
        return expertRepository.save(expert);
    }

    private void validateRequest(ExpertRequest request) {
        Set<ConstraintViolation<ExpertRequest>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            List<String> errorMessages = violations.stream().map(ConstraintViolation::getMessage).toList();
            throw new CustomBadRequestException(String.join(",", errorMessages));
        }
    }

    private void validateMultiPartFile(MultipartFile multipartFile) {
        if (multipartFile.getSize() > 300 * 1024) {
            throw new CustomBadRequestException("File size exceeds the maximum limit of 300 KB");
        }
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !fileName.toLowerCase().endsWith(".jpg")) {
            throw new CustomBadRequestException("File format must be JPG");
        }
    }

    private Expert createExpert(MultipartFile multipartFile, ExpertRequest request) {
        SubDuty foundSubDuty = subDutyService.findByName(request.getNameSubDuty());
        Expert expert = new Expert();
        expert.setFirstName(request.getFirstName());
        expert.setLastName(request.getLastName());
        expert.setEmail(request.getEmail());
        expert.setPassword(request.getPassword());
        expert.setRegistrationDate(LocalDate.now());
        expert.setRegistrationTime(LocalTime.now());
        expert.setExpertStatus(ExpertStatus.DISABLE);
        expert.setPictureData(multipartFile.getOriginalFilename());
        expert.setScore(0);
        expert.setSubDuties(Collections.singleton(foundSubDuty));
        expert.setWallet(walletService.save(new Wallet(0.0)));
        return expert;
    }

    @Override
    public ExpertSummaryResponse expertConfirmation(ExpertRequestWithEmail request) {
        return expertRepository.findByEmail(request.getEmail())
                .map(expert -> {
                    if (expert.getExpertStatus() == ExpertStatus.DISABLE) {
                        expert.setExpertStatus(ExpertStatus.ENABLE);
                        return expertMapper.expertToExpertSummaryResponse(expertRepository.save(expert));
                    } else {
                        throw new CustomBadRequestException("This expert is enable");
                    }
                })
                .orElseThrow(() -> new CustomEntityNotFoundException("no expert was found with this id"));
    }

    @Override
    public Expert findById(Long id) {
        return expertRepository.findById(id)
                .orElseThrow(() -> new CustomEntityNotFoundException("expert with this id was not found"));
    }

    @Override
    public Expert findByEmail(String email) {
        return expertRepository.findByEmail(email)
                .orElseThrow(() -> new CustomEntityNotFoundException("Expert with this email was not found"));
    }

    @Override
    public List<ExpertSummaryResponse> findAllDisableExperts() {
        List<Expert> expertList = expertRepository.findAllByExpertStatus(ExpertStatus.DISABLE);
        if (expertList.isEmpty()) {
            throw new CustomResourceNotFoundException("There is no result");
        } else {
            return expertList.stream().map(expertMapper::expertToExpertSummaryResponse).toList();
        }
    }

    @Override
    public List<ExpertSummaryResponse> findAll() {
        List<Expert> expertList = expertRepository.findAll();
        if (expertList.isEmpty()) {
            throw new CustomResourceNotFoundException("There is no result");
        } else {
            return expertList.stream().map(expertMapper::expertToExpertSummaryResponse).toList();
        }
    }
}
