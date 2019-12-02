import { User } from './user';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})

export class UserserviceService 
{
  private mailingUrl: string;

  constructor(private http: HttpClient) 
  {
    this.mailingUrl = 'http://localhost:2000/send-email';
  }

  public sendMail(user: User)
  {
    return this.http.post<User>(this.mailingUrl, user)
  }

}
