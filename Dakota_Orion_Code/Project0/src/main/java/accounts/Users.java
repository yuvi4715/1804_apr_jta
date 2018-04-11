package accounts;

public class Users {
	private static int curNumID=1;
	private String password;
	private int iD;
	private int userName;
	private boolean approved = false;
	private String type= "User";
	public Users(){
		generateID();
	}
	
	public Users(String str) {
		if(str.equals("Admin")||str.equals("admin")) {
			this.type="Admin";
			this.approved=true;
			generateID();
		}
		else {
			System.out.println("Invalid String Entered, 'User' accountType made");
		}
	}
	
	private void generateID() {
		iD=curNumID++;
	}
	
	public int getID() {
		return iD;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String str) {
		if(str.equals("Admin")||str.equals("admin")) {
			this.type="Admin";
		}
		else {
			System.out.println("Invalid String Entered, 'User' accountType made");
		}
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void getStatus() {
		System.out.println("UserID: " + getID());
		System.out.println("Approval status: " + isApproved());
		System.out.println("Account Type: " + getType());
	}

	public int getUserName() {
		return userName;
	}

	public void setUserName(int userName) {
		this.userName = userName;
	}
}
