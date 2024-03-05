import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import {Etat, User} from './user';


@Injectable({
  providedIn: 'root'
})
export class UserService {



  private baseURL: string = "http://localhost:8080/api/user";

  constructor(private httpClient: HttpClient) { }


  getUserList(): Observable<User[]>{
    return this.httpClient.get<User[]>(this.baseURL);
 }

  addUser(user: User): Observable<Object>{
    user.etat = Etat.UNBLOCKED;
    return this.httpClient.post(`${this.baseURL}`, user);
  }

  getUserById(id: number): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/${id}`);
  }


  updateUser(id: number, user: User): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, user);
  }

  deleteUser(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }




}
