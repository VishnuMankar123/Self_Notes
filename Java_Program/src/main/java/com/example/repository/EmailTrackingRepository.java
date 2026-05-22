package com.example.repository;

import com.example.entity.EmailTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTrackingRepository extends JpaRepository<EmailTracking, Long> {
}