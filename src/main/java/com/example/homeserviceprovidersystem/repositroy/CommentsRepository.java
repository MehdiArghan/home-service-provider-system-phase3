package com.example.homeserviceprovidersystem.repositroy;

import com.example.homeserviceprovidersystem.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
