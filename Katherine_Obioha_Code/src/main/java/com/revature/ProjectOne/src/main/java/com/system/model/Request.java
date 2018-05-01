package com.system.model;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1932556983782219756L;
	private int ID;
	private double reqamount;
	private User requester;
	private User reviewer;
	private Date requestdate;
	private String status;
	private String requestdetails;
	private Date reviewdate;
	
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getReqamount() {
		return reqamount;
	}
	public void setReqamount(double reqamount) {
		this.reqamount = reqamount;
	}
	public User getRequester() {
		return requester;
	}
	public void setRequester(User requester) {
		this.requester = requester;
	}
	public User getReviewer() {
		return reviewer;
	}
	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	public Date getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		System.out.println(status);
		if(status.equalsIgnoreCase("N"))
		{
			this.status = "Not approved";
		}
		if(status.equalsIgnoreCase("Y"))
		{
			this.status = "Approved";
		}
		if(status.equalsIgnoreCase("D"))
		{
			this.status = "Declined";
		}
	}
	public String getRequestdetails() {
		return requestdetails;
	}
	public void setRequestdetails(String requestdetails) {
		this.requestdetails = requestdetails;
	}
	public Date getReviewdate() {
		return reviewdate;
	}
	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		long temp;
		temp = Double.doubleToLongBits(reqamount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((requestdate == null) ? 0 : requestdate.hashCode());
		result = prime * result + ((requestdetails == null) ? 0 : requestdetails.hashCode());
		result = prime * result + ((requester == null) ? 0 : requester.hashCode());
		result = prime * result + ((reviewdate == null) ? 0 : reviewdate.hashCode());
		result = prime * result + ((reviewer == null) ? 0 : reviewer.hashCode());
		result = prime * result + ((status ==null) ? 0  : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (ID != other.ID)
			return false;
		if (Double.doubleToLongBits(reqamount) != Double.doubleToLongBits(other.reqamount))
			return false;
		if (requestdate == null) {
			if (other.requestdate != null)
				return false;
		} else if (!requestdate.equals(other.requestdate))
			return false;
		if (requestdetails == null) {
			if (other.requestdetails != null)
				return false;
		} else if (!requestdetails.equals(other.requestdetails))
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
			return false;
		if (reviewdate != other.reviewdate)
			return false;
		if (reviewer == null) {
			if (other.reviewer != null)
				return false;
		} else if (!reviewer.equals(other.reviewer))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Request [ID=" + ID + ", reqamount=" + reqamount + ", requester=" + requester + ", reviewer=" + reviewer
				+ ", requestdate=" + requestdate + ", status=" + status + ", requestdetails=" + requestdetails
				+ ", reviewdate=" + reviewdate + "]";
	}
	
	
}
