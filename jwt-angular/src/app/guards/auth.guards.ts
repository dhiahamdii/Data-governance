import { Injectable } from '@angular/core';
import { JwtService } from '../service/jwt.service';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(private tokenService: JwtService,
              private router: Router) {}

  canActivate() {
    return this.checkAuth();
  }

  private checkAuth() {
    const authed = this.tokenService.getToken() != null;
    return authed || this.routeToLogin();
  }

  private routeToLogin(): boolean {
    this.router.navigateByUrl('/login');
    return false;
  }

}
