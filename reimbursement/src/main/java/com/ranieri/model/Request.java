package com.ranieri.model;

public class Request {
	
	int requestID;
	String email;
	String reason;
	double amount;
	String status;
	String manager;
	String image;
	
	public Request() {
		
	}

	public Request(int requestID, String email, String reason, double amount, String status, String manager,
			String image) {
		super();
		this.requestID = requestID;
		this.email = email;
		this.reason = reason;
		this.amount = amount;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	@Override
	public String toString() {
		return " RequestID=" + requestID + ", requestor" + email + ",  " + reason + ",  $" + amount
				+ ",  " + status + ", viewed by  " + manager + ", image description  " + image + "";
	}
	
	
	
	

}
