import { Injectable } from '@angular/core';
import { ReinbursementReceipt } from './ReinbursementReceipt';
import { Employee } from './Employee';
import { HttpClient, HttpRequest,HttpHeaders,HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Router} from '@angular/router';

@Injectable()
export class DatabaseGetterService {
	public endpoint = 'http://localhost:8080/ProjectOne/fc/';
	public user;
	public errorMsg;
	public isAdmin = false;
  constructor(private http:HttpClient,private router:Router) { }
  
  
  getReceipts(page,getActivated):Observable<ReinbursementReceipt[]>{
	  return this.http.get<ReinbursementReceipt[]>(this.endpoint+'?format=json&page='+page+'&getAproved='+getActivated,
	  {
		   headers: {'command':'GetRequestReceipts'}
	  })
	  .catch(this.errorHandler);
  }
  
  getEmployees(page):Observable<Employee[]>{
	  return this.http.get<Employee[]>(this.endpoint+'?format=json&page='+page,
	  {
		   headers: {'command':'GetAllEmployees'}
	  })
	  .catch(this.errorHandler);
  }
  
  errorHandler(error : HttpErrorResponse){
	  console.log(error);
	  return Observable.throw(error.message || 'Server Error')
  }
  logoutUser(){
	  return this.http.get(this.endpoint+'?format=json',
	  {
		   headers: {'command':'LogOut'}
	  }).subscribe(
	  data => {
		  console.log(data);
		  this.router.navigateByUrl('/');
	  },
	  error =>{ 
		this.errorMsg = error
		this.router.navigateByUrl('/');
	  });
  }
  search(checked,query,page):Observable<ReinbursementReceipt[]> {
   let formData: FormData = new FormData();  
   formData.append("format", "json");
   formData.append("getAproved", checked);
   formData.append("query", query);
   formData.append("page", page);
   let temp = this.http.post<ReinbursementReceipt[]>(this.endpoint, formData, { headers: {'command':'SearchCommand'} });
   return temp;
  }
  loginUser(email,password,checked){
   let formData: FormData = new FormData();  
   formData.append("format", "json");
   formData.append("email", email);
   formData.append("password", password); 
   formData.append("checked", checked);
   let temp = this.http.post(this.endpoint, formData, { headers: {'command':'ProcessLoginPost'} });
   temp.subscribe(
	  data => {
		  console.log(data);
		  this.user = data['employee'];
		  if(this.user==null){
			  this.user = data['manager'];
			  if(this.user!=null)
				this.isAdmin = true;
		  } else 
			  this.isAdmin = false;
		  console.log(this.user);
		  if(this.user['email']===email)
			this.router.navigateByUrl('/main');
	  },
	  error => this.errorMsg = error);
   return temp;
  }
  postFile(fileToUpload: File,amount,description): Observable<boolean> {
    const formData: FormData = new FormData();
	formData.append("format", "json");
	formData.append("amount", amount);
	formData.append("description", description);
    formData.append('image', fileToUpload, fileToUpload.name);
	
    return this.http.post(this.endpoint, formData, {headers:{ "command": "UploadReinbursementReceipt" }})
      .catch(this.errorHandler);
  }
   postEmployee(email,fname,lname,password): Observable<boolean> {
    const formData: FormData = new FormData();
	formData.append("format", "json");
	formData.append("email", email);
	formData.append("fname", fname);
	formData.append("lname", lname);
	formData.append("password", password);
    return this.http.post(this.endpoint, formData, {headers:{ "command": "UploadEmployee" }})
      .catch(this.errorHandler);
  }
  postReinbursementRequest(id,status): Observable<boolean> {
    const formData: FormData = new FormData();
	formData.append("format", "json");
	formData.append("status", status);
	formData.append("id", id);
    return this.http.post(this.endpoint, formData, {headers:{ "command": "UpdateReinbursementReceipt" }})
      .catch(this.errorHandler);
  }
}
