import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {

  constructor(private _databaseService:DatabaseGetterService,private router:Router) { }
  public status;
  ngOnInit() {
  }
logout(){
	  this._databaseService.logoutUser();
	  console.log("LogOut");
  }
  back(){
	  console.log("Back");
	  this.router.navigateByUrl('/main');
  }
  onSubmit(email,fname,lname,password,confirm){
	  if(password.value !== confirm.value)
	  {
		  this.status= "passwords dont match";
		  return;
	  }
	  this.status=null;
	  email.disabled=true;
	  fname.disabled=true;
	  lname.disabled=true;
	  password.disabled=true;
	  confirm.disabled=true;
	  this._databaseService.postEmployee(email.value,fname.value,lname.value,password.value).subscribe(data => {
	    console.log(data);
		  this.status=null;
		  email.disabled=false;
		  fname.disabled=false;
		  lname.disabled=false;
		  password.disabled=false;
		  confirm.disabled=false;
      }, error => {
        console.log(error);
		this.status=null;
		  email.disabled=false;
		  fname.disabled=false;
		  lname.disabled=false;
		  password.disabled=false;
		  confirm.disabled=false;
      });
  }
}
