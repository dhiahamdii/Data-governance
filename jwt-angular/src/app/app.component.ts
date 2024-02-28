import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/service/jwt.service';
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

  ngOnInit(): void {
    this.currentUser = this.currentUser.getUser();
  }

  logout(): void {

        localStorage.removeItem('token');
        this.router.navigate(['/login']).then(() => {
          window.location.reload();
        });

  }
}
