package com.revature.ers.model;

import java.io.Serializable;
import java.sql.Date;

public class Request implements Serializable{
	private static final long serialVersionUID = 1L;
	private int request_id;
	private int requester;
	private int reviewer;
	private double req_amount;
    private String purpose;
    private String status;
    private Date request_date;
    private Date review_date;
    
	public Request(int request_id, int requester, int reviewer, double req_amount, String purpose, String status,
			Date request_date, Date review_date) {
		super();
		this.request_id = request_id;
		this.requester = requester;
		this.reviewer = reviewer;
		this.req_amount = req_amount;
		this.purpose = purpose;
		this.status = status;
		this.request_date = request_date;
		this.review_date = review_date;
	}

	public Request() {
		super();
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public int getRequester() {
		return requester;
	}

	public void setRequester(int requester) {
		this.requester = requester;
	}

	public int getReviewer() {
		return reviewer;
	}

	public void setReviewer(int reviewer) {
		this.reviewer = reviewer;
	}

	public double getReq_amount() {
		return req_amount;
	}

	public void setReq_amount(double req_amount) {
		this.req_amount = req_amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		long temp;
		temp = Double.doubleToLongBits(req_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((request_date == null) ? 0 : request_date.hashCode());
		result = prime * result + request_id;
		result = prime * result + requester;
		result = prime * result + ((review_date == null) ? 0 : review_date.hashCode());
		result = prime * result + reviewer;
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
		if (Double.doubleToLongBits(req_amount) != Double.doubleToLongBits(other.req_amount))
			return false;
		if (request_date == null) {
			if (other.request_date != null)
				return false;
		} else if (!request_date.equals(other.request_date))
			return false;
		if (request_id != other.request_id)
			return false;
		if (requester != other.requester)
			return false;
		if (review_date == null) {
			if (other.review_date != null)
				return false;
		} else if (!review_date.equals(other.review_date))
			return false;
		if (reviewer != other.reviewer)
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
		return "Request [request_id=" + request_id + ", requester=" + requester + ", reviewer=" + reviewer
				+ ", req_amount=" + req_amount + ", purpose=" + purpose + ", status=" + status + ", request_date="
				+ request_date + ", review_date=" + review_date + "]";
	}
	
	
    
}