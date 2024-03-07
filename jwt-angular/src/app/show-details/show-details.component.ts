import { Component } from '@angular/core';
import {User} from "../user";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../user.service";

@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.scss']
})
export class ShowDetailsComponent {



  id: number
  user!: User
  constructor(private route: ActivatedRoute, private userService: UserService) {

    this.id=0
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    this.userService.getUserById(this.id).subscribe( data => {
      this.user = data;
    });
  }

}
