/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.model;

import java.io.Serializable;
import java.util.Date;

/**
 *  Java Bean representing a reimbursement request @ Project 1
 */
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;
	private int requestID;
	private double requestAmount;
	private String requester;
	private String reviewer;
	private String status;
	private String purpose;
	private Date requestDate;
	private Date reviewDate;

	public Request(int requestID, double requestAmount, String requester, String reviewer, String status,
			String purpose, Date requestDate, Date reviewDate) {
		super();
		this.requestID = requestID;
		this.requestAmount = requestAmount;
		this.requester = requester;
		this.reviewer = reviewer;
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

	public double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
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

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
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
		result = prime * result + requestID;
		result = prime * result + ((requester == null) ? 0 : requester.hashCode());
		result = prime * result + ((reviewDate == null) ? 0 : reviewDate.hashCode());
		result = prime * result + ((reviewer == null) ? 0 : reviewer.hashCode());
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
		if (Double.doubleToLongBits(requestAmount) != Double.doubleToLongBits(other.requestAmount))
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
		if (reviewer == null) {
			if (other.reviewer != null)
				return false;
		} else if (!reviewer.equals(other.reviewer))
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
		return "Request [requestID=" + requestID + ", requestAmount=" + requestAmount + ", requester=" + requester
				+ ", reviewer=" + reviewer + ", status=" + status + ", purpose=" + purpose + ", requestDate="
				+ requestDate + ", reviewDate=" + reviewDate + "]";
	}

}
