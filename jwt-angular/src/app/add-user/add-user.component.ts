import { Component } from '@angular/core';
import { User } from '../user';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, FormsModule, NgForm, Validators} from '@angular/forms';
import {Role} from "../Role";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent {


  constructor(
    private userService: UserService,
    private router: Router,
    private formBuilder: FormBuilder,
    private http: HttpClient

  ) { }

  user: User = new User();
  roles: Role[] = [];
  newIdrole: number = 0;
  userForm !:FormGroup;

  ngOnInit():void {
    this.userForm=this.formBuilder.group({
      fname:['',Validators.required],
      username:['',Validators.required],
      role:['',Validators.required],
      email:['',Validators.required],
      password:['',Validators.required]
    });
  }


  role:string='';
  selectRole(event : any){
    this.role=event.target.value;
  }

  addUserr() {
    // Assuming userForm is your form group holding the form data
    this.user.fname = this.userForm.value.fname;
    this.user.username = this.userForm.value.username;
    this.user.password = this.userForm.value.password;
    this.user.email = this.userForm.value.email;

    // Retrieve the selected role ID from the form
    const selectedRoleId = (parseInt(this.role, 10))-1;

    // Create a new Role instance
    const role = new Role(selectedRoleId);

    // Assign the role to the user
    this.user.role = role;

    // Add the user
    this.userService.addUser(this.user).subscribe(() => {
      console.log("User added successfully");
      this.router.navigate(['/list-user']);
    });



    this.http.post<any>('http://localhost:8080/api/mail', this.user.email).subscribe(
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

  goToUserList() {
    this.router.navigate(['/list-user']);
  }

  onSubmit() {
    this.addUserr();

  }

}
