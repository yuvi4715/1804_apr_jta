import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  public receipts = [];
  public errorMsg;
  public page = 0;
  public getApproved = false;
  public ENTERKEYCODE = 13;
  
  constructor(private _databaseService:DatabaseGetterService,
			  private router:Router) { 
  }
  
  ngOnInit() {
	  this._databaseService.getReceipts(this.page,this.getApproved).subscribe(
	  data => this.receipts = data,
	  error => this.errorMsg = error);
  }
  onKey(event,checked,query,mySearchbar){
	if(event.keyCode==this.ENTERKEYCODE)
	{
	  mySearchbar.disabled = true;
	  this._databaseService.search(checked,query,this.page).subscribe(
	  data => {
		  this.receipts = data;
		  console.log(data);
		  mySearchbar.disabled = false;
	  },
	  error => {
		  mySearchbar.disabled = false;
		  this.errorMsg = error
	  });
	}
  }
  generateReceipt(){
	  console.log("viewEmployee");
	  this.router.navigateByUrl('/receiptRegister');
  }
  viewEmployee(){
	  console.log("viewEmployee");
	  this.router.navigateByUrl('/viewEmployees');
  }
  registerNewUser(){
	  console.log("Register");
	  this.router.navigateByUrl('/register');
  }
  logout(){
	  this._databaseService.logoutUser();
	  console.log("LogOut")
  }
  setHandler(receipt,user){
	  console.log(user);
	  receipt.handledBy = user;
  }
  onAprove(receipt){
	  receipt.status = 1;
	  this._databaseService.postReinbursementRequest(receipt.id,receipt.status).subscribe(
	  data => {
		  console.log(data);
		  this.setHandler(receipt,this._databaseService.user);
	  },
	  error => {});
  }
  onDeny(receipt){
	  receipt.status = 2;
	  this._databaseService.postReinbursementRequest(receipt.id,receipt.status).subscribe(
	  data => {
		  console.log(data);
		  this.setHandler(receipt,this._databaseService.user);
	  },
	  error => {});
	  console.log("denied "+receipt.id);
  }
  onChange(receipt){
	  receipt.status = 0;
	  this._databaseService.postReinbursementRequest(receipt.id,receipt.status).subscribe(
	  data => {
		  console.log(data);
	  },
	  error => {});
	  console.log("changed "+receipt.id);
  }
  checkboxIsClicked(myCheckbox){
	  myCheckbox.checked=!myCheckbox.checked;
	  this.getApproved=myCheckbox.checked;
	  this._databaseService.getReceipts(this.page,this.getApproved).subscribe(
	  data => this.receipts = data,
	  error => this.errorMsg = error);
  }
  onPreviousPage(){
	  if(this.page>0){
		  this.page--;
	  }
	  this._databaseService.getReceipts(this.page,this.getApproved).subscribe(
	  data => this.receipts = data,
	  error => this.errorMsg = error);
  }
  onNextPage(){
	  this.page++;
	  this._databaseService.getReceipts(this.page,this.getApproved).subscribe(
	  data => this.receipts = data,
	  error => this.errorMsg = error);
  }		
}
