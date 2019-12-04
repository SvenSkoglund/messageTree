import { MessageComponent } from './message/message.component';

export class Message {
    id: number;
    content: string;
    parentMesesage: Message;
    parentID: number;
    childMessages: Array<MessageComponent>;
    likes: number;
    timestamp: Date;
    hasParentMessage: Boolean;

    constructor(){
    }

    
}
