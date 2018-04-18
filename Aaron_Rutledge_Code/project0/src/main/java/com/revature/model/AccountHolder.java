package com.revature.model;

import java.io.Serializable;
import java.util.Calendar;

public class AccountHolder implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4909371687178889718L;
	private int UserID;
	private String fName;
	private String lName;
	private Calendar joinDate;
	private String pass;
	private int sFlag;
	
	public AccountHolder() {
		super();
		this.UserID = 0;
		this.joinDate = null;
		this.sFlag = 0;
	};
	
	public AccountHolder(String fName, String lName, String pass) {
		super();
		this.UserID = 0;
		this.fName = fName;
		this.lName = lName;
		this.joinDate = null;
		this.pass = pass;
		this.sFlag = 0;
	}
	public AccountHolder(int userID, String fName, String lName, Calendar joinDate, String pass, int sFlag) {
		super();
		UserID = userID;
		this.fName = fName;
		this.lName = lName;
		this.joinDate = joinDate;
		this.pass = pass;
		this.sFlag = sFlag;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Calendar getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getsFlag() {
		return sFlag;
	}
	public void setsFlag(int sFlag) {
		this.sFlag = sFlag;
	}
	@Override
	public String toString() {
		return "AccountHolder [UserID=" + UserID + ", fName=" + fName + ", lName=" + lName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UserID;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + sFlag;
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
		AccountHolder other = (AccountHolder) obj;
		if (UserID != other.UserID)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (sFlag != other.sFlag)
			return false;
		return true;
	}
	
	

}
