package com.example.homeserviceprovidersystem.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface CaptchaService {
    void generateCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
