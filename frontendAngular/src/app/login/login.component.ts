import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'Yeisonint'
  password = ''
  invalidLogin = false

  // constructor(private router: Router,
  //   private loginservice: AuthenticationService) { }

  // ngOnInit() {
  // }

  constructor(){
  }
  ngOnInit(): void {
  }

  // checkLogin() {
  //   if (this.loginservice.authenticate(this.username, this.password)) {
  //     this.router.navigate([''])
  //     this.invalidLogin = false
  //   }else
  //     this.invalidLogin = true
  // }

}
