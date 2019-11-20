import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Message } from './message';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { MessageComponent } from './message/message.component';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  getAll() {
    return this.http.get<Array<MessageComponent>>(this.url + 'messages')
    .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
    );
  }

  private url = 'http://localhost:8090/api/';


  show(key) {
    return this.http.get<MessageComponent>(this.url + 'message/' + key)
        .pipe(
            catchError((err: any) => {
              console.log(err);
              return throwError('KABOOM');
            })
        );
  }

  create(message: Message) {
    console.log('in user service');
    return this.http.post<MessageComponent>(this.url + 'message', message)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }

  destroy(key: string) {
    console.log(key);
    return this.http.delete(this.url + 'message/' + key)
        .pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError('KABOOM');
          })
        );
  }

  constructor(private http: HttpClient) { }
}