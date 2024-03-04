import { Component } from '@angular/core';
import {User} from "../user";
import {UserService} from "../user.service";
import {Router} from "@angular/router";
import { JwtService } from 'src/app/service/jwt.service';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent {

  users: User[];
  EnteredID!:number;

  constructor(private userService: UserService,  private router: Router) {
    this.users=[];

  }

  ngOnInit(): void {

    // this.employees = [
    //   { "id":1,fname: 'John', lname: 'Doe', email: 'john@example.com', salary: 50000, department: 'IT', designation: 'Developer' },

    // ];

    this.getUsers();
  }


  goToUser(){


    console.log(this.EnteredID);
    this.router.navigate(['details-of-user',this.EnteredID]);
  }

  getUsers(){
    this.userService.getUserList().subscribe(data => {this.users = data;});
  }

  updateUser(id: number){
    this.router.navigate(['updating-by-id', id]);
  }




  deleteUser(id: number){

    if(confirm("Are you sure to delete Employee ID: "+id)){
      this.userService.deleteUser(id).subscribe( data => {
        console.log(data);
        this.getUsers();
      })}
  }


  detailsOfUser(id: number){
    this.router.navigate(['details-of-user', id]);
  }

}
