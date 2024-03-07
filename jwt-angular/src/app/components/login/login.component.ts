import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/service/jwt.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup | undefined;
  isLoggedIn = false;

  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  redirectToRegister() {
    this.router.navigate(['/register']);

  }
  redirectToforgetpassword() {
    this.router.navigate(['/forget-password']);
  }
  redirectToLogin() {
    this.router.navigate(['/profile']);

  }
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required, Validators.email],
      password: ['', Validators.required],
    })
  }

  submitForm() {
    this.service.login(this.loginForm.value).subscribe(
      (response) => {
        console.log(response);
        if (response.jwt != null) {
          Swal.fire({
            icon: 'success',
            title: '',
            text: 'Connected successfully!'
          });
          const jwtToken = response.jwt;
          localStorage.setItem('jwt', jwtToken);
          this.isLoggedIn = true;
          this.router.navigateByUrl("/dashboard");

        }
      },
      (error) => {
        // Handle error
        console.log(error);
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Wrong email or password!'
        });
      }
    )
  }
}
