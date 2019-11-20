import { Component, OnInit } from '@angular/core';
import { Message } from '../message';
import { MessageComponent } from '../message/message.component';

import { MessageService } from '../message-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  messageTree: Array<MessageComponent>;
  constructor(private messageService: MessageService) { }

  ngOnInit() {
    this.messageTree = [new MessageComponent()];
    this.messageService.getAll().subscribe(
      data => {
        this.messageTree = data;
        console.log(this.messageTree);
        
      }
      ,
      err => {
        console.log(err);
        alert('Error loading message tree')
      }
    )
  }

}
