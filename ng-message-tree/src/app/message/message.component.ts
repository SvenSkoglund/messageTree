import { Component, OnInit } from '@angular/core';
import { Message } from '../message';
@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  inputs: ['message'],
  styleUrls: ['./message.component.css'],
  providers: [
    MessageComponent,
    Message
  ],
})
export class MessageComponent implements OnInit {
  message: Message;
  content: String;
  hasChildMessages: Boolean = false;

  constructor(message?: Message) {
    this.message = message;
    if (this.message) {
    }
  }

  ngOnInit() {
    //this.message = new Message();
    if(this.message && this.message.childMessages && this.message.childMessages.length > 0){
      console.log('child messages', this.message.childMessages);
      this.hasChildMessages = true;
    }
  }

}
