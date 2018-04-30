package com.revature.beans;

public class Login {
	private String username;
	private String password;
	private String favColor;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String username, String password, String favColor) {
		super();
		this.username = username;
		this.password = password;
		this.favColor = favColor;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFavColor() {
		return favColor;
	}
	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((favColor == null) ? 0 : favColor.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Login other = (Login) obj;
		if (favColor == null) {
			if (other.favColor != null)
				return false;
		} else if (!favColor.equals(other.favColor))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", favColor=" + favColor + "]";
	}
}
