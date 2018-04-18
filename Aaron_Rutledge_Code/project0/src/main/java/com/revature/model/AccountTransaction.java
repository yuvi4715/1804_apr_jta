package com.revature.model;

import java.io.Serializable;
import java.util.Calendar;

public class AccountTransaction implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1570892168318109871L;
	private int transID;
	private int actNum;
	private int actType;
	private double adjust;
	private Calendar tdate;
	private String note;
	
	public AccountTransaction(int actNum, int actType, double adjust, Calendar tdate, String note) {
		super();
		this.transID = 0;
		this.actNum = actNum;
		this.actType = actType;
		this.adjust = adjust;
		this.tdate = tdate;
		this.note = note;
	}

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public int getActNum() {
		return actNum;
	}

	public void setActNum(int actNum) {
		this.actNum = actNum;
	}

	public int getActType() {
		return actType;
	}

	public void setActType(int actType) {
		this.actType = actType;
	}

	public double getAdjust() {
		return adjust;
	}

	public void setAdjust(double adjust) {
		this.adjust = adjust;
	}

	public Calendar getTdate() {
		return tdate;
	}

	public void setTdate(Calendar tdate) {
		this.tdate = tdate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actNum;
		result = prime * result + actType;
		long temp;
		temp = Double.doubleToLongBits(adjust);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((tdate == null) ? 0 : tdate.hashCode());
		result = prime * result + transID;
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
		AccountTransaction other = (AccountTransaction) obj;
		if (actNum != other.actNum)
			return false;
		if (actType != other.actType)
			return false;
		if (Double.doubleToLongBits(adjust) != Double.doubleToLongBits(other.adjust))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (tdate == null) {
			if (other.tdate != null)
				return false;
		} else if (!tdate.equals(other.tdate))
			return false;
		if (transID != other.transID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction Number: " + transID + ", Account Number: " + actNum + "-" + actType 
				+ "Amount: " + adjust + "Date: " + tdate + "Note: " + note;
	}
}
