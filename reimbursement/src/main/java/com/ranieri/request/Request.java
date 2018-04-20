package com.ranieri.request;

public class Request {
	
	int requestID;
	String email;
	String status;
	String manager;
	String image;
	
	public Request() {
		
	}
	
	
	

	public Request(int requestID, String email, String status, String manager, String image) {
		super();
		this.requestID = requestID;
		this.email = email;
		this.status = status;
		this.manager = manager;
		this.image = image;
	}



	

	public int getRequestID() {
		return requestID;
	}




	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getManager() {
		return manager;
	}




	public void setManager(String manager) {
		this.manager = manager;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
