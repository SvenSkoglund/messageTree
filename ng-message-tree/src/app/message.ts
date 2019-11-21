export class Message {
    id: number;
    content: string;
    parentMesesage: Message;
    childMessages: [];
    likes: number;
    timestamp: Date;
    hasParentMessage: Boolean;

    constructor(){
    }

    
}
