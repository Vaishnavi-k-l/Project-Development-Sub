import { UserserviceService } from './userservice.service';
import { User } from './user';
import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent 
{
  user: User;

  constructor(private userService: UserserviceService)
  {
    this.user = new User();
  }

  onSubmit()
  {
    this.userService.sendMail(this.user).subscribe(data=>
      {
        console.log("Mail sent");
      })
  }

  title = 'Mailing';
}
