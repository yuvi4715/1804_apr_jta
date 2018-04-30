package com.revature.model;

import java.io.Serializable;

public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int requestID;
	private float requestAmount;
	private String requester;
	private String reviewedBy;
	private String status;
	private String purpose;
	private String requestDate;
	private String reviewDate;
	
	public Request() {
	}

	public Request(int requestID, float requestAmount, String requester, String reviewedBy, String status, String purpose,
			String requestDate, String reviewDate) {
		super();
		this.requestID = requestID;
		this.requestAmount = requestAmount;
		this.requester = requester;
		this.reviewedBy = reviewedBy;
		this.status = status;
		this.purpose = purpose;
		this.requestDate = requestDate;
		this.reviewDate = reviewDate;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public float getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(float requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}


	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", requestAmount=" + requestAmount + ", requester=" + requester
				+ ", reviewedBy=" + reviewedBy + ", status=" + status + ", purpose=" + purpose + ", requestDate="
				+ requestDate + ", reviewDate=" + reviewDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + Float.floatToIntBits(requestAmount);
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + requestID;
		result = prime * result + ((requester == null) ? 0 : requester.hashCode());
		result = prime * result + ((reviewDate == null) ? 0 : reviewDate.hashCode());
		result = prime * result + ((reviewedBy == null) ? 0 : reviewedBy.hashCode());
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
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (Float.floatToIntBits(requestAmount) != Float.floatToIntBits(other.requestAmount))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (requestID != other.requestID)
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
			return false;
		if (reviewDate == null) {
			if (other.reviewDate != null)
				return false;
		} else if (!reviewDate.equals(other.reviewDate))
			return false;
		if (reviewedBy == null) {
			if (other.reviewedBy != null)
				return false;
		} else if (!reviewedBy.equals(other.reviewedBy))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
