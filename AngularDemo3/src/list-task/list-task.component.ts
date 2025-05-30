import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { TaskService } from '../services/task.service';

@Component({
  selector: 'app-list-task',
  imports: [CommonModule],
  templateUrl: './list-task.component.html',
  styleUrl: './list-task.component.css'
})
export class ListTaskComponent {
  localitems: string[]=[]

  constructor(private service:TaskService){
    this.localitems=this.service.getItem()
  }

}
