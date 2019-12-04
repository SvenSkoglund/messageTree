import { Component, OnInit, Input } from '@angular/core';
import { Message } from '../message';
import { MessageService } from '../message-service.service';
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
  @Input() message: Message;
  hasChildMessages: Boolean = true;
  addingComment: Boolean = false;
  replyMessage: Message;
  
  constructor(message?: Message, private messageService?: MessageService) {
    this.message = message;
    if (!this.message || !this.message.childMessages || this.message.childMessages.length! > 0) {
      this.hasChildMessages = false;
    }
  }

  ngOnInit() {
    //this.message = new Message();
    if (this.message && this.message.childMessages && this.message.childMessages.length > 0) {
      console.log('child messages', this.message.childMessages);
      this.hasChildMessages = true;
    }
  }

  reply() {
    this.addingComment = true;
    this.generateNewReplyMessage();
    this.message.childMessages.push(new MessageComponent(this.replyMessage));
  }

  generateNewReplyMessage() {
    this.replyMessage = new Message();
    this.replyMessage.parentMesesage = new Message();
    this.replyMessage.parentID = this.message.id;
    console.log('generateNewReplyMessage', this.message.id);
    
  }

  saveReply(){
    this.message.timestamp = new Date(Date.now());
    console.log('saveReply', this.message);

    this.messageService.create(this.message).subscribe(
      data => {
  console.log(data);
  
      }
      ,
      err => {
        console.log(err);
        alert('Error loading message tree')
      }
    );
  }

}
