package accounts;

public class Users {
	private static int curNumID=1;
	private int iD;
	private boolean approved = false;
	private String status= "User";
	public Users(){
		generateID();
	}
	
	public Users(String str) {
		if(str.equals("Admin")||str.equals("admin")) {
			this.status="Admin";
			this.approved=true;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String str) {
		if(str.equals("Admin")||str.equals("admin")) {
			this.status="Admin";
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
}
