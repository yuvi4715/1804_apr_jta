import { Component, OnInit } from '@angular/core';
import { DatabaseGetterService } from '../database-getter.service';


@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  constructor(private _databaseService:DatabaseGetterService) { }
	public errorMsg = "";
  ngOnInit() {
  }
  loginSubmit(email,password,checked,loadingImage,submitButton){
	if (loadingImage.style.display === "none") {
		loadingImage.style.display = "block";
		submitButton.disabled = true;
	} 
	  console.log(email);
	  console.log(password);
	  this._databaseService.loginUser(email,password,checked).subscribe(
	  data => {
		  loadingImage.style.display = "none";
		  submitButton.disabled = false;
		  console.log(data);
	  },
	  error => {
		  loadingImage.style.display = "none";
		  submitButton.disabled = false;
		  this.errorMsg = error
	  });
  }
  checkboxIsClicked(myCheckbox){
	  myCheckbox.checked=!myCheckbox.checked;
  }
}
