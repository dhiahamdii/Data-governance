import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.scss']
})
export class ForgetPasswordComponent {



  constructor(
    private router: Router
  ) { }

  redirectToLogin() {
    this.router.navigate(['/login']);

  }
  redirectToRegister() {
    this.router.navigate(['/register']);

  }

}
