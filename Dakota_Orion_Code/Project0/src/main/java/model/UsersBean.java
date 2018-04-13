package model;

import java.io.Serializable;

public class UsersBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int UsersBeanId;
	private String password;
	private String type;
	private String approve;
	
	public UsersBean() {}
	

	public UsersBean(String password, String type, String approve) {
		super();
		this.password = password;
		this.type = type;
		this.approve = approve;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UsersBeanId;
		result = prime * result + ((approve == null) ? 0 : approve.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		UsersBean other = (UsersBean) obj;
		if (UsersBeanId != other.UsersBeanId)
			return false;
		if (approve == null) {
			if (other.approve != null)
				return false;
		} else if (!approve.equals(other.approve))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	public int getUsersBeanId() {
		return UsersBeanId;
	}


	public void setUsersBeanId(int UsersBeanId) {
		this.UsersBeanId = UsersBeanId;
	}


	public String getpassword() {
		return password;
	}


	public void setpassword(String password) {
		this.password = password;
	}


	public String gettype() {
		return type;
	}


	public void settype(String type) {
		this.type = type;
	}


	public String getapprove() {
		return approve;
	}


	public void setapprove(String approve) {
		this.approve = approve;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "UserInfo [ID=" + UsersBeanId+", password=" + password + ", type=" + type + ", approve=" + approve + "]";
	}
	
}
