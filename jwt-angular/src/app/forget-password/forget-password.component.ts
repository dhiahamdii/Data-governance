import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {CustomerService} from "../customer.service";
import {NgForm} from "@angular/forms";
import {User} from "../user";
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.scss']
})
export class ForgetPasswordComponent {


  email: String = '';
  constructor(
    private router: Router,
    private customerService: CustomerService,
    private http: HttpClient
  ) { }

  onSubmit() {
        this.http.post<any>('http://localhost:8080/api/mail', this.email ).subscribe(
      response => {
        console.log('Email sent successfully');
        // Optionally handle success response
      },
      error => {
        console.error('Error sending email:', error);
        // Optionally handle error response
      }
    );
  }

  redirectToLogin() {
    this.router.navigate(['/login']);

  }

  redirectToRegister() {
    this.router.navigate(['/register']);

  }

}
