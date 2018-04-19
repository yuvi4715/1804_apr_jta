package com.revature.model;

import java.io.Serializable;

public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int id;
	private static int money;
	private String username;
	private String password;
	private String name;
	private int status;
	
	public Bank() {}

	public Bank(int id, int money, String username, String password, String name, int status) {
		super();
		this.id = id;
		this.money = money;
		this.username = username;
		this.password = password;
		this.setSecondaryType(name);
		this.status = status;
	}

	public static int getMoney() {
		return money;
	}

	public void setPokedexEntry(int money) {
		this.money = money;
	}

	public String getName() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public String getPrimaryType() {
		return password;
	}

	public void setPrimaryType(String password) {
		this.password = password;
	}

	public String getSecondaryType() {
		return name;
	}

	public void setSecondaryType(String name) {
		if (name == null) {
			this.name = "N/A";
		}
		this.name = name;
	}

	public int getGeneration() {
		return status;
	}

	public void setGeneration(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + status;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + money;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Bank other = (Bank) obj;
		if (status != other.status)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (money != other.money)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (status == 0) {
			return "Hello user " + name + ", you have $" + money + " available in your account. Your userusername is " + username + ". Your password is " + password;
		} else if (status == 1) {
			return "Hello unregistered user " + name + ", you have $" + money + " available in your account. Your userusername is " + username + ". Your password is " + password;
		} else {
			return "Hello Admin " + name + ", you have $" + money + " available in your account. Your userusername is " + username + ". Your password is " + password;

		}
	}

	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}