package joey.bank.model;
/**
 * The BankUser model object for the DAO design of the Bank app.
 * @author joeyi
 *
 */
public class BankUser 
{
	private int account_number;
	private String lastname;
	private String firstname;
	private String username;
	private String psw;
	private int admin_id; //Id of the admin responsible for user
	private int user_id;
	
/* user_id NUMBER(8,0) CHECK (user_id BETWEEN 0 AND 99999999) PRIMARY KEY, 
   admin_id NUMBER(8,0) CHECK (admin_id BETWEEN 0 AND 99999999),
   firstname VARCHAR2(16) NOT NULL, --20 bytes max
   lastname VARCHAR2(16) NOT NULL,  --20 char max
   username VARCHAR(16) NOT NULL, --16char max
   password VARCHAR2(16) NOT NULL --16char max*/
	
	public BankUser(String username,String password, String firstname, String lastname) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.username = username;
		this.psw = password;
	}
	
	
	
	@Override
	public String toString() {
		return "BankUser [account_number=" + account_number + ", lastname=" + lastname + ", firstname=" + firstname
				+ ", username=" + username + ", admin_id=" + admin_id + ", user_id=" + user_id + "]";
	}


	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_number;
		result = prime * result + admin_id;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((psw == null) ? 0 : psw.hashCode());
		result = prime * result + user_id;
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
		BankUser other = (BankUser) obj;
		if (account_number != other.account_number)
			return false;
		if (admin_id != other.admin_id)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (psw == null) {
			if (other.psw != null)
				return false;
		} else if (!psw.equals(other.psw))
			return false;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
