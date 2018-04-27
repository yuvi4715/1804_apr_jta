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
}
