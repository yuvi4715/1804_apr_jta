package com.revature.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.util.ConnectionUtil;

public class Reimbursment implements Serializable 
{
	private static final long serialVersionUID = 5420166647566586668L;
	private String email;
	private String reviewedBy;
	private int requestID;
	private String status;
	private double amount;
	private String purpose;
	private Timestamp request_date;
	private Timestamp review_date;
	
	public Reimbursment() {}

	public Reimbursment(String email, String reviewedBy, int requestID, String status, double amount, String purpose,
			Timestamp request_date, Timestamp review_date) {
		super();
		this.email = email;
		this.reviewedBy = reviewedBy;
		this.requestID = requestID;
		this.status = status;
		this.amount = amount;
		this.purpose = purpose;
		this.request_date = request_date;
		this.review_date = review_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public int getRequestID(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reimbursement WHERE em_email = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
			{
				return rs.getInt("request_id");
			}
		} 
		catch (SQLException sqle)
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return 0;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Timestamp getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Timestamp request_date) {
		this.request_date = request_date;
	}

	public Timestamp getReview_date() {
		return review_date;
	}

	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + requestID;
		result = prime * result + ((request_date == null) ? 0 : request_date.hashCode());
		result = prime * result + ((review_date == null) ? 0 : review_date.hashCode());
		result = prime * result + ((reviewedBy == null) ? 0 : reviewedBy.hashCode());
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
		Reimbursment other = (Reimbursment) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (requestID != other.requestID)
			return false;
		if (request_date == null) {
			if (other.request_date != null)
				return false;
		} else if (!request_date.equals(other.request_date))
			return false;
		if (review_date == null) {
			if (other.review_date != null)
				return false;
		} else if (!review_date.equals(other.review_date))
			return false;
		if (reviewedBy == null) {
			if (other.reviewedBy != null)
				return false;
		} else if (!reviewedBy.equals(other.reviewedBy))
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
		return "Reimbursment [Email: " + email + "| Reviewed By: " + reviewedBy + "| ID: " + requestID + "| Status: "
				+ status + "| Amount:  $" + amount + "| Purpose: " + purpose + "| Request Date: " + request_date
				+ "| reviewed: " + review_date + "]";
	}
	
	
	
	
}
