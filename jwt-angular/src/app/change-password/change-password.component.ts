import { Component, OnInit } from '@angular/core';
import { Customer } from "../customer";
import { CustomerService } from "../customer.service";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {

  id: any;
  customer: Customer = new Customer();

  constructor(private customerService: CustomerService,
              private route: ActivatedRoute,
              private router: Router) {}



  changePassword(userId: number, oldPassword: string, newPassword: string): void {
    this.customerService.changePassword(userId, oldPassword, newPassword).subscribe(
      () => {
        // Password changed successfully, handle success message or navigation here
      },
      error => {
        // Handle error, display error message or log the error
        console.error('Error changing password:', error);
      }
    );
  }


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.customerService.getCustomerById(this.id).subscribe(data => {
      this.customer = data;
    }, error => console.log(error));
  }

  onSubmit(): void {
    this.customerService.updateCustomer(this.id, this.customer).subscribe(data => {
      this.goToUserList();
    }, error => console.log(error));
  }

  goToUserList(): void {
    this.router.navigate(['/profile']);
  }
}