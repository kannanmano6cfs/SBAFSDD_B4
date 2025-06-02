import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { OtpService } from '../services/otp.service';

@Component({
  selector: 'app-otp',
  imports: [FormsModule, CommonModule],
  templateUrl: './otp.component.html',
  styleUrl: './otp.component.css'
})
export class OtpComponent {
  email: string='';
  otp: string='';
  message: string='';
  otpsent: boolean=false;
  success: boolean=false;

  constructor(private service:OtpService){}

  requestOtp(){
    this.service.sendOtp(this.email).subscribe({
      next: (response) =>{
        this.otpsent=true;
        this.success=true;
        this.message=response.message;
      },
      error: () =>{
        this.message="Failed to send OTP";
        this.success=false;
      }
    });
  }

  confirmOtp(){
    this.service.verifyOtp(this.email,this.otp).subscribe({
      next:(response) =>{
        this.message=response.message;
        this.success=true;
      },
      error: () =>{
        this.message="Invalid OTP";
        this.success=false;
      }
    });
  }
}
