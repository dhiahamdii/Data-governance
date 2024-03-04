import { Component } from '@angular/core';
import {CustomerService} from "../customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Customer} from "../customer";

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.scss']
})
export class UpdateProfileComponent {




  id: number;
  customer: Customer = new Customer();


  constructor(private customerService: CustomerService,
              private route: ActivatedRoute,
              private router: Router) {
    this.id=0
  }
  //loading the data into form
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.customerService.getCustomerById(this.id).subscribe(data => {
      this.customer = data;
    }, error => console.log(error));


  }

  onSubmit(){
    this.customerService.updateCustomer(this.id, this.customer).subscribe( data =>{
        this.goToUserList();
      }
      , error => console.log(error));
  }

  goToUserList(){
    this.router.navigate(['/list-user']);
  }
}
