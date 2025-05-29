import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-main',
  imports: [FormsModule, CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  welcome="Welcome to the Application"

  num1: number =656
  num2: number =986

  img1: string = "images\\teamtraining.jpg"
  altTxt: string = "Image Unavailable now...!!"

  text: string = ""
  message: string = "AWS Courses"
  flag: boolean = true

  height: string ="300px"
  classname: string ="class1"

  courses: string[]=[
    "AWS Courses", "VMware Courses", "Development Courses", "Testing Courses"
  ]


  showText(){
    this.text="Hello Everyone!! Register for access the details"
  }

  showCourses(){
    this.flag=true
  }

  hideCourses(){
    this.flag=false
  }

  changeHeight(){
    if(this.height=="300px")
      this.height="500px"
    else
      this.height="300px"
  }

  changeClass(){
    if(this.classname=="class1")
      this.classname="class2"
    else
      this.classname="class1"
  }

}
