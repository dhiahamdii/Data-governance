import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import {Customer} from './customer';



@Injectable({
  providedIn: 'root'
})
export class CustomerService {



  private baseURL: string = "http://localhost:8080/api/customer";

  constructor(private httpClient: HttpClient) { }



  changePassword(userId: number, oldPassword: string, newPassword: string): Observable<any> {
    const url = `${this.baseURL}/change-password/${userId}?oldPassword=${oldPassword}&newPassword=${newPassword}`;
    return this.httpClient.put<any>(url, null); // Pass null as the request body
  }




  getCustomerList(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(this.baseURL);
  }


  getCustomerById(id: number): Observable<Customer>{
    return this.httpClient.get<Customer>(`${this.baseURL}/1`);
  }


  updateCustomer(id: number, customer: Customer): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, customer);
  }

  deleteCustomer(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }




}
