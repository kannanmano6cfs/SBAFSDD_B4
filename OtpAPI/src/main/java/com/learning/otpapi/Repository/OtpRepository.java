package com.learning.otpapi.Repository;

import com.learning.otpapi.Model.otpData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<otpData, Integer> {
    Optional<otpData> findByEmail(String email);
}
