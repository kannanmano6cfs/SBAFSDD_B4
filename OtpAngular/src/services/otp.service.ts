import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OtpService {

  private apiurl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  sendOtp(email: string): Observable<any>{
    const params = new HttpParams().set('email',email);
    return this.http.post<any>(`${this.apiurl}/send`,{},{ params })

  }

  verifyOtp(email: string, otp: string): Observable<any>{
    const params = new HttpParams().set('email',email).set('otp',otp);
    return this.http.post<any>(`${this.apiurl}/verify`,{},{ params })
  }
}
