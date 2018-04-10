package accounts;

import java.util.ArrayList;
import java.util.Hashtable;

public class MyBank {
	Hashtable<Integer, ArrayList<Account>> accounts = new Hashtable<Integer, ArrayList<Account>>();
	Hashtable<Integer,Users> allUsers = new Hashtable<Integer, Users>();
	ArrayList<Users> unApproved = new ArrayList<Users>();
	
	public void createUser() {
		Users nUsers = new Users();
		allUsers.put(nUsers.getID(), nUsers);
		addUnapproved(nUsers);
	}
	
	public void addUnapproved(Users user) {
		unApproved.add(user);
		for(int i=0;i<unApproved.size();i++) {
			if(unApproved.get(i).isApproved()==true) {
				unApproved.remove(i);
			}
		}
	}
	
	public void createAdminUser() {
		Users nUsers = new Users("Admin");
		allUsers.put(nUsers.getID(), nUsers);
	}
	
	public void createAccount(String str, int userID) {
		if(str.equals("checking")||str.equals("Checking")) {
			
		}
		else if(str.equals("Savings")||str.equals("savings")) {
			
		}
		else if(str.equals("credit")||str.equals("credit")) {
			
		}
	}
	
	public static void main(String[] args) {
		
	}
}
