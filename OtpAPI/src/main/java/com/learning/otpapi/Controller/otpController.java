package com.learning.otpapi.Controller;

import com.learning.otpapi.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class otpController {

    @Autowired
    private OtpService otpService;

    //send otp
    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String email){
        return new ResponseEntity<>(otpService.sendOTP(email), HttpStatus.OK);
    }

    //verifyy otp
    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp){
        return new ResponseEntity<>(otpService.verify(email, otp), HttpStatus.OK);
    }
}
