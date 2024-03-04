import { Component } from '@angular/core';
import {Customer} from "../customer";
import {ActivatedRoute} from "@angular/router";
import {CustomerService} from "../customer.service";
import {Router} from "@angular/router";
import {UserService} from "../user.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {



  id: number
  customer!: Customer
  constructor(private route: ActivatedRoute, private customerService: CustomerService,private router: Router) {

    this.id=0
  }


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.customer = new Customer();
    this.customerService.getCustomerById(this.id).subscribe( data => {
      this.customer = data;
    });
  }
  updateCustomer(id: number){
    this.router.navigate(['update-profile', id]);
  }
}
