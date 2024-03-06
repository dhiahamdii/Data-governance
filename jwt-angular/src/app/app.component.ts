import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import { JwtService } from 'src/app/service/jwt.service';

import {Customer} from "./customer";
import {CustomerService} from "./customer.service";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'jwt-angular';

  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router
  ) {

  }

  currentUser: any;
  id: number
  ngOnInit(): void {
    this.currentUser = this.currentUser.getUser();

  }

  updateCustomer(id: number){
    this.router.navigate(['update-profile', id]);
  }


  logout(): void {

    this.service.logouut(this)

        localStorage.removeItem('jwt');


        this.router.navigate(['/login']).then(() => {

          window.location.reload();

        });

  }

}
