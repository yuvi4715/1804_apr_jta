package com.revature.model;

import java.io.Serializable;

public class Image implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Image fields
	private int picID;
	private Byte pic;
	private String uploadedBy;
	private int requestAssociate;
	public Image() {
	}
	
	public Image(int picID, Byte pic, String uploadedBy, int requestAssociate) {
		super();
		this.picID = picID;
		this.pic = pic;
		this.uploadedBy = uploadedBy;
		this.requestAssociate = requestAssociate;
	}

	public int getPicID() {
		return picID;
	}
	public void setPicID(int picID) {
		this.picID = picID;
	}
	public Byte getPic() {
		return pic;
	}
	public void setPic(Byte pic) {
		this.pic = pic;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public int getRequestAssociate() {
		return requestAssociate;
	}
	public void setRequestAssociate(int requestAssociate) {
		this.requestAssociate = requestAssociate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + picID;
		result = prime * result + requestAssociate;
		result = prime * result + ((uploadedBy == null) ? 0 : uploadedBy.hashCode());
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
		Image other = (Image) obj;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (picID != other.picID)
			return false;
		if (requestAssociate != other.requestAssociate)
			return false;
		if (uploadedBy == null) {
			if (other.uploadedBy != null)
				return false;
		} else if (!uploadedBy.equals(other.uploadedBy))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Image [picID=" + picID + ", pic=" + pic + ", uploadedBy=" + uploadedBy + ", requestAssociate="
				+ requestAssociate + "]";
	}
}
