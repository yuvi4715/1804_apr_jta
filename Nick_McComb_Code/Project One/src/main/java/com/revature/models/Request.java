package com.revature.models;

public class Request {
	private int id, requester, handler, img_id;
	private String status, purpose, comment;
	private Double amount;
	
	public Request(int id, int requester, int handler, int img_id, double amount, String status, String purpose, String comment) {
		super();
		this.id = id;
		this.requester = requester;
		this.handler = handler;
		this.img_id = img_id;
		this.amount = amount;
		this.status = status;
		this.purpose = purpose;
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public int getRequester() {
		return requester;
	}
	public int getHandler() {
		return handler;
	}
	public void setHandler(int handler) {
		this.handler = handler;
	}
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", requester=" + requester + ", handler=" + handler + ", img_id=" + img_id
				+ ", status=" + status + ", purpose=" + purpose + ", comment=" + comment + ", amount=" + amount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + handler;
		result = prime * result + id;
		result = prime * result + img_id;
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + requester;
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (handler != other.handler)
			return false;
		if (id != other.id)
			return false;
		if (img_id != other.img_id)
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (requester != other.requester)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
