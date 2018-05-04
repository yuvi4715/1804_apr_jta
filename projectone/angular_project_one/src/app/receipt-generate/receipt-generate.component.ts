import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-receipt-generate',
  templateUrl: './receipt-generate.component.html',
  styleUrls: ['./receipt-generate.component.css']
})
export class ReceiptGenerateComponent implements OnInit {

  constructor(private _databaseService:DatabaseGetterService,private router:Router) { }
  public fileToUpload: File = null;
  public status = "idle";
  ngOnInit() {
  }
  back(){
	  console.log("Back");
	  this.router.navigateByUrl('/main');
  }
  logout(){
	  this._databaseService.logoutUser();
	  console.log("LogOut")
  }
  onSubmit(Amount,Description) {
	  if(this.fileToUpload==null){
		Amount.disabled=false;
	    Description.disabled=false;
		this.status = "pending";
	  }
	  Amount.disabled=true;
	  Description.disabled=true;
	  this.status = "loading";
	  console.log(Amount.value);
	  console.log(Description.value);
    this._databaseService.postFile(this.fileToUpload,Amount.value,Description.value).subscribe(data => {
      // do something, if upload success
	    Amount.disabled=false;
	    Description.disabled=false;
		this.status = "idle";
	    console.log(data);
	    console.log("upload finished");
      }, error => {
		Amount.disabled=false;
	    Description.disabled=false;
		this.status = "idle";
        console.log(error);
      });
  }
  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
  }
}
