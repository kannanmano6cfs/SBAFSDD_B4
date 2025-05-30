import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SummaryPipe } from '../app/pipes/summary.pipe';

@Component({
  selector: 'app-register',
  imports: [FormsModule,CommonModule,SummaryPipe],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  title: string="Koenig-solutions"
  paragraph: string="Angular is a comprehensive framework and platform, primarily used for building single-page applications (SPAs) and progressive web applications (PWAs). It's maintained by Google and the Angular community, offering tools and libraries for creating robust and scalable web applications. Angular is built on TypeScript and utilizes a component-based architecture, enabling developers to create modular and reusable code"

  onSubmit(data:any){
    console.log(data);
  }
}
