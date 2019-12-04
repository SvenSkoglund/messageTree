import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MessageComponent } from './message/message.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    MessageComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, FormsModule

  ],
  providers: [
    HomeComponent,
    MessageComponent
  ],
  bootstrap: [AppComponent]

})
export class AppModule { }
