import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {
  public employees = [];
  public errorMsg;
  public page = 0;
  constructor(private _databaseService:DatabaseGetterService,
			  private router:Router) { }

  ngOnInit() {
  this._databaseService.getEmployees(this.page).subscribe(
	  data => {
		  this.employees = data
		  console.log(data);
	  },
	  error => this.errorMsg = error);
  }
  onPreviousPage(){
	  if(this.page>0){
		  this.page--;
	  }
	  this._databaseService.getEmployees(this.page).subscribe(
	  data => {
		  this.employees = data
		  console.log(data);
	  },
	  error => this.errorMsg = error);
  }
  onNextPage(){
	  this.page++;
	  this._databaseService.getEmployees(this.page).subscribe(
	  data => {
		  this.employees = data
		  console.log(data);
	  },
	  error => this.errorMsg = error);
  }
  registerNewUser(){
	  console.log('register');
	  this.router.navigateByUrl('/register');
  }
  back(){
	  console.log("Back");
	  this.router.navigateByUrl('/main');
  }
  logout(){
	  this._databaseService.logoutUser();
	  console.log("LogOut")
  }
  viewEmployee(){
	  console.log("ViewEmployee")
  }
}
