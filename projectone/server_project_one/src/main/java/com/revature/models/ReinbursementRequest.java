package com.revature.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReinbursementRequest {
	private long id;
	private String imageURL;
	private Manager handledBy;
	private Employee owner;
	private String description;
	private double amount;
	private short status;
	private boolean isDeleted=false;
	ReinbursementRequest(){}
	
	public ReinbursementRequest(long id, String imageURL, Manager handledBy, Employee owner, String description,
			double amount, short status, boolean isDeleted) {
		super();
		this.id = id;
		this.imageURL = imageURL;
		this.handledBy = handledBy;
		this.owner = owner;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.isDeleted = isDeleted;
	}
	@XmlElement
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@XmlElement
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	@XmlElement
	public Manager getHandledBy() {
		return handledBy;
	}
	public void setHandledBy(Manager handledBy) {
		this.handledBy = handledBy;
	}
	@XmlElement
	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@XmlElement
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	@XmlElement
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "ReinbursementRequest [id=" + id + ", imageURL=" + imageURL + ", handledBy=" + handledBy + ", owner="
				+ owner + ", description=" + description + ", amount=" + amount + ", status=" + status + ", isDeleted="
				+ isDeleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((handledBy == null) ? 0 : handledBy.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + status;
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
		ReinbursementRequest other = (ReinbursementRequest) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (handledBy == null) {
			if (other.handledBy != null)
				return false;
		} else if (!handledBy.equals(other.handledBy))
			return false;
		if (id != other.id)
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
