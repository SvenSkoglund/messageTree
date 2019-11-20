export class Message {
    id: number;
    content: string;
    parentMesesage: Message;
    childMessages: Array<Message>;
    likes: number;
    timestamp: Date;

    constructor(){
    }
}
