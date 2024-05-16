package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.dto.comments.CommentRequest;
import com.example.homeserviceprovidersystem.dto.comments.CommentResponse;

public interface CommentsService {
    CommentResponse save(CommentRequest request);
}
