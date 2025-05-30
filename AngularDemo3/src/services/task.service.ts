import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor() { }

  private items: string[]=[] //share the data

  addItem(item:string) {
    this.items.push(item)
  }

  getItem(): string[] {
    return this.items
  }
}
