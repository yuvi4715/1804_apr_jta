package com.revature.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Request implements Serializable {

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestAmount=" + requestAmount + ", requester=" + requester
				+ ", reviewedBy=" + reviewedBy + ", statusOfRequest=" + statusOfRequest + ", purpose=" + purpose
				+ ", requestDate=" + requestDate + ", reviewDate=" + reviewDate + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1830891572472071003L;
	private int requestId;
	private double requestAmount;
	private int requester;
	private int reviewedBy;
	private String statusOfRequest;
	private String purpose;
	private Timestamp requestDate;
	private Timestamp reviewDate;
		
	public Request(int requestId, double requestAmount, int requester, int reviewedBy, String statusOfRequest,
			String purpose, Timestamp requestDate, Timestamp reviewDate) {
		super();
		this.requestId = requestId;
		this.requestAmount = requestAmount;
		this.requester = requester;
		this.reviewedBy = reviewedBy;
		this.statusOfRequest = statusOfRequest;
		this.purpose = purpose;
		this.requestDate = requestDate;
		this.reviewDate = reviewDate;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public double getRequestAmount() {
		return requestAmount;
	}
	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}
	public int getRequester() {
		return requester;
	}
	public void setRequester(int requester) {
		this.requester = requester;
	}
	public int getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(int reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public String getStatusOfRequest() {
		return statusOfRequest;
	}
	public void setStatusOfRequest(String statusOfRequest) {
		this.statusOfRequest = statusOfRequest;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Timestamp getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}
	public Timestamp getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		long temp;
		temp = Double.doubleToLongBits(requestAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + requestId;
		result = prime * result + requester;
		result = prime * result + ((reviewDate == null) ? 0 : reviewDate.hashCode());
		result = prime * result + reviewedBy;
		result = prime * result + ((statusOfRequest == null) ? 0 : statusOfRequest.hashCode());
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
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (Double.doubleToLongBits(requestAmount) != Double.doubleToLongBits(other.requestAmount))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (requestId != other.requestId)
			return false;
		if (requester != other.requester)
			return false;
		if (reviewDate == null) {
			if (other.reviewDate != null)
				return false;
		} else if (!reviewDate.equals(other.reviewDate))
			return false;
		if (reviewedBy != other.reviewedBy)
			return false;
		if (statusOfRequest == null) {
			if (other.statusOfRequest != null)
				return false;
		} else if (!statusOfRequest.equals(other.statusOfRequest))
			return false;
		return true;
	}
	
	
	
	
	
}
