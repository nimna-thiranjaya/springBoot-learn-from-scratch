import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  constructor(private userService: UserServiceService) {}

  login(data: NgForm) {
    let request = {
      userName: data.value.email,
      password: data.value.password,
    };
    this.userService.login(request).subscribe(
      (response) => {},
      (error) => {
        console.log(error);
      }
    );
  }
}
