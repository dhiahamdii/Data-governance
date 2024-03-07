import { Component } from '@angular/core';
import {User} from "../user";
import {UserService} from "../user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Role} from "../Role";

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent {



  id!: number;
  user1: User = new User();


  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private router: Router) {
  }

  user: User = new User();
  roles: Role[] = [];
  newIdrole: number = 0;

  userForm !:FormGroup;


  ngOnInit(): void {
    this.userForm=this.formBuilder.group({
      fname:['',Validators.required],
      username:['',Validators.required],
      role:['',Validators.required],
      email:['',Validators.required],
      password:['',Validators.required]
    });


    this.id = this.route.snapshot.params['id'];
    console.warn(this.id)
    this.userService.getUserById(this.id).subscribe(data => {
      this.userForm.controls["fname"].setValue(data.fname)
      this.userForm.controls["username"].setValue(data.username)
      this.userForm.controls["email"].setValue(data.email)
      this.userForm.controls["password"].setValue(data.password)
      this.user1 = data;
    }, error => console.log(error));

  }


  role:string='';
  selectRole(event : any){
    this.role=event.target.value;
  }
  onSubmit(){
    this.user.fname = this.userForm.value.fname;
    this.user.username = this.userForm.value.username;
    this.user.password = this.userForm.value.password;
    this.user.email = this.userForm.value.email;
    const selectedRoleId = (parseInt(this.role, 10))-1;
    const role = new Role(selectedRoleId);
    this.user.role = role;
    this.userService.updateUser(this.id, this.user).subscribe(() => {
      console.log("User updated successfully");
      this.router.navigate(['/list-user']);
    });

  }

  goToUserList(){
    this.router.navigate(['/list-user']);
  }
}
