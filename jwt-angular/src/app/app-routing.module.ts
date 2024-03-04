import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {ProfileComponent} from "./profile/profile.component";
import {AddUserComponent} from "./add-user/add-user.component";
import {ListUserComponent} from "./list-user/list-user.component";
import {ForgetPasswordComponent} from "./forget-password/forget-password.component";
import {UpdateUserComponent} from "./update-user/update-user.component";
import {ShowDetailsComponent} from "./show-details/show-details.component";
import {UpdateProfileComponent} from "./update-profile/update-profile.component";

const routes: Routes = [
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent },
  { path: "dashboard", component: DashboardComponent },
  { path: "profile", component: ProfileComponent },
  { path: "add-user", component: AddUserComponent },
  { path: "list-user", component: ListUserComponent },
  { path: "forget-password", component: ForgetPasswordComponent },
  {path:'updating-by-id/:id',component:UpdateUserComponent},
  {path:'details-of-user/:id',component:ShowDetailsComponent},
  {path:'update-profile/:id',component:UpdateProfileComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
