import { Component } from '@angular/core';
import { User } from '../user';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent {


  constructor(
    private userService: UserService,
    private router: Router,

  ) {

  }
  submitform!: NgForm;
  private baseURL = "http://localhost:8080/api/v1/user";
  user: User = new User();

  saveUser() {
    this.userService.addUser(this.user).subscribe(data => {
        console.log(data);
        this.goToUserList();
      },
      error => console.log(error));
  }

  goToUserList() {
    this.router.navigate(['/list-user']);
  }

  ngOnInit(): void { }
  onSubmit() {
    console.log(this.user);
    this.saveUser();
  }


}









