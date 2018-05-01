package com.revature.model;

import java.io.Serializable;
import java.util.Calendar;

public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -310750071781649108L;
	
	private int requestAmount;
	private String requester;
	private String reviewedBy;
	private String status;
	private String purpose;
	
	public Request(int requestAmount, String requester, String reviewedBy, String status, String purpose) {
		super();
		this.requestAmount = requestAmount;
		this.requester = requester;
		this.reviewedBy = reviewedBy;
		this.status = status;
		this.purpose = purpose;
	}

	public int getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(int requestAmount) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + requestAmount;
		result = prime * result + ((requester == null) ? 0 : requester.hashCode());
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
		if (requestAmount != other.requestAmount)
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
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

	@Override
	public String toString() {
		return "Request [requestAmount=" + requestAmount + ", requester=" + requester + ", reviewedBy=" + reviewedBy
				+ ", status=" + status + ", purpose=" + purpose + "]";
	}
	
}
