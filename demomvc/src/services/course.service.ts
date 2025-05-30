import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[]=[
    { id:0, name:'Azure Az104', description:'Microsoft Certified: Azure Administrator', instructor:'XXXXX'},
    { id:1, name:'Azure AI102', description:'Microsoft Certifed Azure AI Engineer', instructor:'YYYYY'}
  ];

  constructor() { }

  getCourses(){
    return of(this.courses);
  }
}
