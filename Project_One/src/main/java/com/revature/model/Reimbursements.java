package com.revature.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

public class Reimbursements {
	Reimbursements() {
		
	}

	private int reimb_id;
	private double reimb_amount;
	private Timestamp reimb_request;
	private Timestamp reimb_review;
	@XmlElement
	private String reimb_purpose;
	private int reimb_requester;
	private int reimb_reviewer;
	private String reimb_status;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimb_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimb_id;
		result = prime * result + ((reimb_purpose == null) ? 0 : reimb_purpose.hashCode());
		result = prime * result + ((reimb_request == null) ? 0 : reimb_request.hashCode());
		result = prime * result + reimb_requester;
		result = prime * result + ((reimb_review == null) ? 0 : reimb_review.hashCode());
		result = prime * result + reimb_reviewer;
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		return result;
	}



	public Reimbursements(int reimb_id, double reimb_amount, Timestamp reimb_request, Timestamp reimb_review,
			String reimb_purpose, int reimb_requester, int reimb_reviewer, String reimb_status) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_request = reimb_request;
		this.reimb_review = reimb_review;
		this.reimb_purpose = reimb_purpose;
		this.reimb_requester = reimb_requester;
		this.reimb_reviewer = reimb_reviewer;
		this.reimb_status = reimb_status;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_request="
				+ reimb_request + ", reimb_review=" + reimb_review + ", reimb_purpose=" + reimb_purpose
				+ ", reimb_requester=" + reimb_requester + ", reimb_reviewer=" + reimb_reviewer + ", reimb_status="
				+ reimb_status + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursements other = (Reimbursements) obj;
		if (Double.doubleToLongBits(reimb_amount) != Double.doubleToLongBits(other.reimb_amount))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (reimb_purpose == null) {
			if (other.reimb_purpose != null)
				return false;
		} else if (!reimb_purpose.equals(other.reimb_purpose))
			return false;
		if (reimb_request == null) {
			if (other.reimb_request != null)
				return false;
		} else if (!reimb_request.equals(other.reimb_request))
			return false;
		if (reimb_requester != other.reimb_requester)
			return false;
		if (reimb_review == null) {
			if (other.reimb_review != null)
				return false;
		} else if (!reimb_review.equals(other.reimb_review))
			return false;
		if (reimb_reviewer != other.reimb_reviewer)
			return false;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		return true;
	}
	
	@XmlElement
	public int getReimb_id() {
		return reimb_id;
	}
	
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	@XmlElement
	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	@XmlElement
	public Timestamp getReimb_request() {
		return reimb_request;
	}

	public void setReimb_request(Timestamp reimb_request) {
		this.reimb_request = reimb_request;
	}
	@XmlElement
	public Timestamp getReimb_review() {
		return reimb_review;
	}

	public void setReimb_review(Timestamp reimb_review) {
		this.reimb_review = reimb_review;
	}
	@XmlElement
	public String getReimb_purpose() {
		return reimb_purpose;
	}

	public void setReimb_purpose(String reimb_purpose) {
		this.reimb_purpose = reimb_purpose;
	}
	@XmlElement
	public int getReimb_requester() {
		return reimb_requester;
	}

	public void setReimb_requester(int reimb_requester) {
		this.reimb_requester = reimb_requester;
	}
	@XmlElement
	public int getReimb_reviewer() {
		return reimb_reviewer;
	}

	public void setReimb_reviewer(int reimb_reviewer) {
		this.reimb_reviewer = reimb_reviewer;
	}
	@XmlElement
	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	

}
