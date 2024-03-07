import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import {User} from './user';


@Injectable({
  providedIn: 'root'
})
export class UserService {



  private baseURL: string = "http://localhost:8080/api/user";

  constructor(private httpClient: HttpClient) { }


  getUserList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}/getAll`);
 }

  addUser(usr: User): Observable<Object>{
    console.warn(usr)
    return this.httpClient.post(`${this.baseURL}/add`, usr);


  }

  getUserById(id: number): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/get/${id}`);
  }


  updateUser(id: number, user: User): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/update/${id}`, user);
  }

  deleteUser(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete/${id}`);
  }




}
