package com.revature.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reimbursement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1044443159126764628L;
	private int reqid;
	private int requesterid;
	private int reviewerid;
	private Employee requester;
	private Employee reviewer;
	private int status; //0 - pending, 1 - approved, 2 - declined
	private String statusStr;
	private Timestamp reqDate;
	private Timestamp revDate;
	private String purpose;
	private String imageURL;
	private double ammount;
	
	public Reimbursement () {}
	
	public Reimbursement(int requesterid, String purpose, String imageURL, double ammount) {
		
		this.requesterid = requesterid;
		this.purpose = purpose;
		this.imageURL = imageURL;
		this.ammount = ammount;
		
		this.reqid = 0;
		this.reviewerid = 0;
		this.requester = null;
		this.reviewer = null;
		this.status = 0;
		this.statusStr = "pending";
		this.reqDate = null;
		this.revDate = null;
		
	}
	
	public Reimbursement(int reqid, int requesterid, int reviewerid, Employee requester, Employee reviewer, int status,
			Timestamp reqDate, Timestamp revDate, String purpose, String imageURL, double ammount) {
		super();
		this.reqid = reqid;
		this.requesterid = requesterid;
		this.reviewerid = reviewerid;
		this.requester = requester;
		this.reviewer = reviewer;
		this.status = status;
		
		this.reqDate = reqDate;
		this.revDate = revDate;
		this.purpose = purpose;
		this.imageURL = imageURL;
		this.ammount = ammount;
		
		if (status == 0  ) {
			this.statusStr = "pending";
		} else if (status == 1) {
			this.statusStr = "approved";
		} else if (status == 2) {
			this.statusStr = "denied";
		}
		
	
	}
	
	

	public int getReqid() {
		return reqid;
	}

	public void setReqid(int reqid) {
		this.reqid = reqid;
	}

	public int getRequesterid() {
		return requesterid;
	}

	public void setRequesterid(int requesterid) {
		this.requesterid = requesterid;
	}

	public int getReviewerid() {
		return reviewerid;
	}

	public void setReviewerid(int reviewerid) {
		this.reviewerid = reviewerid;
	}

	public Employee getRequester() {
		return requester;
	}

	public void setRequester(Employee requester) {
		this.requester = requester;
	}

	public Employee getReviewer() {
		return reviewer;
	}

	public void setReviewer(Employee reviewer) {
		this.reviewer = reviewer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public double getAmmount() {
		return ammount;
	}
	
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((reqDate == null) ? 0 : reqDate.hashCode());
		result = prime * result + reqid;
		result = prime * result + ((requester == null) ? 0 : requester.hashCode());
		result = prime * result + requesterid;
		result = prime * result + ((revDate == null) ? 0 : revDate.hashCode());
		result = prime * result + ((reviewer == null) ? 0 : reviewer.hashCode());
		result = prime * result + reviewerid;
		result = prime * result + status;
		result = prime * result + ((statusStr == null) ? 0 : statusStr.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
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
		if (reqid != other.reqid)
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
			return false;
		if (requesterid != other.requesterid)
			return false;
		if (revDate == null) {
			if (other.revDate != null)
				return false;
		} else if (!revDate.equals(other.revDate))
			return false;
		if (reviewer == null) {
			if (other.reviewer != null)
				return false;
		} else if (!reviewer.equals(other.reviewer))
			return false;
		if (reviewerid != other.reviewerid)
			return false;
		if (status != other.status)
			return false;
		if (statusStr == null) {
			if (other.statusStr != null)
				return false;
		} else if (!statusStr.equals(other.statusStr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reqid=" + reqid + ", requesterid=" + requesterid + ", reviewerid=" + reviewerid
				+ ", requester=" + requester + ", reviewer=" + reviewer + ", status=" + status + ", statusStr="
				+ statusStr + ", reqDate=" + reqDate + ", revDate=" + revDate + ", purpose=" + purpose + ", imageURL="
				+ imageURL + ", ammount=" + ammount + "]";
	}
	
	
	
	
	
	

}
