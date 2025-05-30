package com.learning.otpapi.Service;

import com.learning.otpapi.Model.otpData;
import com.learning.otpapi.Repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    //Send OTP
    public String sendOTP(String email){
        String otp=String.format("%06d", new Random().nextInt(999999));
        otpData otpdata=new otpData(email,otp);
        otpRepository.save(otpdata);
        return "OTP "+otp+" sent successfully";
    }

    //Verify OTP
    public String verify(String email,String otp){
        Optional<otpData> otpdata1=otpRepository.findByEmail(email);
        if(otpdata1.isPresent()){
            otpData otpdata2=otpdata1.get();
            if(otpdata2.getOtp().equals(otp)){
                return "OTP verified successfully";
            }
        }
        return "Invalid OTP";
    }
}
