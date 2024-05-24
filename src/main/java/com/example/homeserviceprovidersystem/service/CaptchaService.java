package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.customeException.CustomIoException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CaptchaService {
    void generateCaptcha(HttpServletRequest request, HttpServletResponse response) throws CustomIoException;
}
