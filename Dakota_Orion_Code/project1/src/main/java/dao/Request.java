package dao;

import java.sql.Blob;
import java.sql.Date;

public class Request {
	int requestId;
	int ammount;
	int requester;
	int reviewedBy;
	String status;
	String purpose;
	java.sql.Blob image;
	java.sql.Date requestDate;
	java.sql.Date reviewDate;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", ammount=" + ammount + ", requester=" + requester + ", reviewedBy="
				+ reviewedBy + ", status=" + status + ", purpose=" + purpose + ", image=" + image + ", requestDate="
				+ requestDate + ", reviewDate=" + reviewDate + "]";
	}
	public Request() {}
	public Request(int requestId, int ammount, int requester, int reviewedBy, String status, String purpose, Blob image,
			Date requestDate, Date reviewDate) {
		super();
		this.requestId = requestId;
		this.ammount = ammount;
		this.requester = requester;
		this.reviewedBy = reviewedBy;
		this.status = status;
		this.purpose = purpose;
		this.image = image;
		this.requestDate = requestDate;
		this.reviewDate = reviewDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ammount;
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + requestId;
		result = prime * result + requester;
		result = prime * result + ((reviewDate == null) ? 0 : reviewDate.hashCode());
		result = prime * result + reviewedBy;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	public Request(int ammount, int requester, String purpose) {
		super();
		this.ammount = ammount;
		this.requester = requester;
		this.purpose = purpose;
		this.image=null;
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
		if (ammount != other.ammount)
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
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
	public java.sql.Blob getImage() {
		return image;
	}
	public void setImage(java.sql.Blob image) {
		this.image = image;
	}
	public java.sql.Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(java.sql.Date requestDate) {
		this.requestDate = requestDate;
	}
	public java.sql.Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(java.sql.Date reviewDate) {
		this.reviewDate = reviewDate;
	}
}
