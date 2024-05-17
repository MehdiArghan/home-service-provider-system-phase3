package com.example.homeserviceprovidersystem.service;

import com.example.homeserviceprovidersystem.dto.comments.CommentRequest;
import com.example.homeserviceprovidersystem.dto.comments.CommentResponse;
import com.example.homeserviceprovidersystem.dto.comments.CommentSummaryRequest;
import com.example.homeserviceprovidersystem.dto.comments.CommentSummaryResponse;

public interface CommentsService {
    CommentResponse save(CommentRequest request);

    CommentSummaryResponse findScore(CommentSummaryRequest request);
}
