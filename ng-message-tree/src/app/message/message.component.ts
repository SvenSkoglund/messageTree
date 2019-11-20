import { Component, OnInit } from '@angular/core';
import { Message } from '../message';
@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  message: Message;
  content: String;


  constructor(message?: Message) {
    this.message = message;
  }

  ngOnInit() {
    this.message = new Message();
  }

}