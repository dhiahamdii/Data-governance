import { Component } from '@angular/core';
import {User} from "../user";
import {UserService} from "../user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent {



  id: number;
  user: User = new User();


  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private router: Router) {
    this.id=0
  }
  //loading the data into form
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.userService.getUserById(this.id).subscribe(data => {
      this.user = data;
    }, error => console.log(error));


  }

  onSubmit(){
    this.userService.updateUser(this.id, this.user).subscribe( data =>{
        this.goToUserList();
      }
      , error => console.log(error));
  }

  goToUserList(){
    this.router.navigate(['/list-user']);
  }
}
