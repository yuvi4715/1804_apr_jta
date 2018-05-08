package com.revature.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -351965254179074518L;
	
	private int requestID;
	private double ammount;
	private int requester;
	private int reviwer;
	private String status;
	private String image;
	private Timestamp reqDate;
	private Timestamp revDate;
	private String purpose;
	
	public Request() {}

	public Request(double ammount, int requester, String purpose) {
		super();
		this.ammount = ammount;
		this.requester = requester;
		this.purpose = purpose;
	}
	
	public Request(int requestID, double ammount, int requester, int reviwer, String status, String image,
			Timestamp reqDate, Timestamp revDate, String purpose) {
		super();
		this.requestID = requestID;
		this.ammount = ammount;
		this.requester = requester;
		this.reviwer = reviwer;
		this.status = status;
		this.image = image;
		this.reqDate = reqDate;
		this.revDate = revDate;
		this.purpose = purpose;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public int getRequester() {
		return requester;
	}

	public void setRequester(int requester) {
		this.requester = requester;
	}

	public int getReviwer() {
		return reviwer;
	}

	public void setReviwer(int reviwer) {
		this.reviwer = reviwer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Timestamp getReqDate() {
		return reqDate;
	}

	public void setReqDate(Timestamp reqDate) {
		this.reqDate = reqDate;
	}

	public Timestamp getRevDate() {
		return revDate;
	}

	public void setRevDate(Timestamp revDate) {
		this.revDate = revDate;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ammount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((reqDate == null) ? 0 : reqDate.hashCode());
		result = prime * result + requestID;
		result = prime * result + requester;
		result = prime * result + ((revDate == null) ? 0 : revDate.hashCode());
		result = prime * result + reviwer;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (Double.doubleToLongBits(ammount) != Double.doubleToLongBits(other.ammount))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (reqDate == null) {
			if (other.reqDate != null)
				return false;
		} else if (!reqDate.equals(other.reqDate))
			return false;
		if (requestID != other.requestID)
			return false;
		if (requester != other.requester)
			return false;
		if (revDate == null) {
			if (other.revDate != null)
				return false;
		} else if (!revDate.equals(other.revDate))
			return false;
		if (reviwer != other.reviwer)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", ammount=" + ammount + ", requester=" + requester + ", reviwer="
				+ reviwer + ", status=" + status + ", image=" + image + ", reqDate=" + reqDate + ", revDate=" + revDate
				+ ", purpose=" + purpose + "]";
	}
	
	
	

}
