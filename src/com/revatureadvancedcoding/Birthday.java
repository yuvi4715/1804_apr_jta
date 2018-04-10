package com.revatureadvancedcoding;

import java.util.Calendar;

//problem 39
public class Birthday {

	private Calendar dob = Calendar.getInstance();
	private String name;
	private int phoneNum;

	public Birthday(String name, int birthYear, int birthMonth, int birthDate) {
		this.name = name;
		this.dob.set(birthYear, birthMonth-1, birthDate);
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	// I want this to return true if today is my birthday
	public boolean isCurrentDayInMonthSameAsBirthDayInMonth() {
		if (Calendar.DAY_OF_MONTH == this.dob.get(this.dob.DAY_OF_MONTH)) {
			return true;
		} else {
			return false;
		}
	}

	// I want this to return true if the month is the same as my birth month
	public boolean isCurrentMonthSameAsBirthMonth() {
		if (Calendar.MONTH == this.dob.get(this.dob.MONTH)) {
			return true;
		} else {
			return false;
		}
	}

}
