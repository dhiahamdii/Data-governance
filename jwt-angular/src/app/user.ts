import { DatePipe } from '@angular/common';
import { Role } from './Role';

export class User {
  id!: number;
  username!:string
  fname!: string;
  email!: string;
  active!:boolean
  role!:Role
  password!:string
}
