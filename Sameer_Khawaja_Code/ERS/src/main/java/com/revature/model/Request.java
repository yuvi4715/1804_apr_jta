package com.revature.model;

public class Request {
	private int request_id;
	private double request_amount;
	private String requester;
	private String reviewed_by;
	private String status;
	private String purpose;
	
	public Request() {
	}
	
	public Request(int request_id, double request_amount, String requester, String reviewed_by, String status,
			String purpose) {
		super();
		this.request_id = request_id;
		this.request_amount = request_amount;
		this.requester = requester;
		this.reviewed_by = reviewed_by;
		this.status = status;
		this.purpose = purpose;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public double getRequest_amount() {
		return request_amount;
	}

	public void setRequest_amount(double request_amount) {
		this.request_amount = request_amount;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getReviewed_by() {
		return reviewed_by;
	}

	public void setReviewed_by(String reviewed_by) {
		this.reviewed_by = reviewed_by;
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
		long temp;
		temp = Double.doubleToLongBits(request_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + request_id;
		result = prime * result + ((requester == null) ? 0 : requester.hashCode());
		result = prime * result + ((reviewed_by == null) ? 0 : reviewed_by.hashCode());
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
		if (Double.doubleToLongBits(request_amount) != Double.doubleToLongBits(other.request_amount))
			return false;
		if (request_id != other.request_id)
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
			return false;
		if (reviewed_by == null) {
			if (other.reviewed_by != null)
				return false;
		} else if (!reviewed_by.equals(other.reviewed_by))
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
		return "Request [request_id=" + request_id + ", request_amount=" + request_amount + ", requester=" + requester
				+ ", reviewed_by=" + reviewed_by + ", status=" + status + ", purpose=" + purpose + "]";
	}
	

	
	
	

}
