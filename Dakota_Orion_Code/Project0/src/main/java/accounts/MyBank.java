package accounts;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class MyBank {
	static Hashtable<Integer, ArrayList<Account>> accounts = new Hashtable<Integer, ArrayList<Account>>();
	static Hashtable<Integer,Users> allUsers = new Hashtable<Integer, Users>();
	static ArrayList<Users> unApproved = new ArrayList<Users>();
	static ArrayList<Account> accountList = new ArrayList<Account>();
	static ArrayList<Users> usersList = new ArrayList<Users>();
	private ArrayList<Account> curAccounts= new ArrayList<Account>();
	Scanner scan = new Scanner(System.in);
	private int curUserID;
	private Users curUser;
	
	public void createUser() {
		System.out.println("Creating Standard User");
		Users nUsers = new Users();
		boolean x=true;
		do {
			System.out.println("Please enter your password");
			String str= scan.nextLine();
			nUsers.setPassword(str);
			System.out.println("Please reenter your password");
			str= scan.nextLine();
			if(nUsers.getPassword().equals(str)) {
				System.out.println("Successfully created an account");
				x=false;
			}
			else {
				System.out.println("Passwords don't match try again");
			}
		}while(x);
		setCurUserID(nUsers.getID());
		setCurUser(nUsers);
		setCurAccounts(accounts.get(curUserID));
		usersList.add(curUser);
		allUsers.put(curUserID, nUsers);
		addUnapproved(nUsers);
		System.out.println("Please wait for an Admin to approve your account");
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
		System.out.println("Creating Admin User");
		Users nUsers = new Users("Admin");
		boolean x=true;
		do {
			System.out.println("Please enter your password");
			String str= scan.nextLine();
			nUsers.setPassword(str);
			System.out.println("Please reenter your password");
			str= scan.nextLine();
			if(nUsers.getPassword().equals(str)) {
				System.out.println("Successfully created an account");
				x=false;
			}
			else {
				System.out.println("Passwords don't match try again");
			}
		}while(x);
		setCurUserID(nUsers.getID());
		setCurUser(nUsers);
		setCurAccounts(accounts.get(getCurUserID()));
		usersList.add(getCurUser());
		allUsers.put(getCurUserID(), nUsers);
	}
	
	public void createAccount(String str, int userID) {
		if(accounts.get(userID)==null) {
			accounts.put(userID,new ArrayList<Account>());
		}
		if(str.equals("checking")||str.equals("Checking")) {
			CheckingAccount acc = new CheckingAccount(0);
			accountList.add(acc);
			accounts.get(userID).add(acc);
		}
		else if(str.equals("Savings")||str.equals("savings")) {
			SavingsAccount acc = new SavingsAccount(0);
			accountList.add(acc);
			accounts.get(userID).add(acc);
		}
		else if(str.equals("credit")||str.equals("credit")) {
			CreditAccount acc = new CreditAccount(1000);
			accountList.add(acc);
			accounts.get(userID).add(acc);
		}
		else {
			System.out.println("Invalid account type, please try again");
			System.out.println("Valid types are 'Checking', 'Savings' and 'Credit'");
		}
		setCurAccounts(accounts.get(getCurUserID()));
	}
	
	public Users getCurUser() {
		return curUser;
	}

	public void setCurUser(Users curUser) {
		this.curUser = curUser;
	}
	
	public void login() {
		boolean x=true;
		do {
			System.out.println("Enter your userID or '0' to create new user");
			int userID = scan.nextInt();
			setCurUserID(userID);
			if(userID==0) {
				scan.nextLine();
				createUser();
				break;
			}
			else if(userID==-1) {
				scan.nextLine();
				createAdminUser();
				break;
			}
			else if(allUsers.containsKey(userID)==false) {
				System.out.println("Invalid ID");
				continue;
			}
			System.out.println("Enter your password");
			String str = scan.nextLine();
			str = scan.nextLine();
			if(str.equals(allUsers.get(curUserID).getPassword())==false) {
				System.out.println("Incorrect Password");
				continue;
			}
			setCurUser(allUsers.get(curUserID));
			setCurAccounts(accounts.get(curUserID));
			x=false;
		}while(x);
	}

	public int getCurUserID() {
		return curUserID;
	}

	public void setCurUserID(int curUserID) {
		this.curUserID = curUserID;
	}
	
	public ArrayList<Account> getCurAccounts() {
		return curAccounts;
	}

	public void setCurAccounts(ArrayList<Account> curAccounts) {
		this.curAccounts = curAccounts;
	}
	
	public void run() {
		boolean running = true;
		while(running) {
			boolean x = true;
			do {
				System.out.println("'login' or 'new user', 'exit'");
				String str = scan.nextLine();
				if(str.equals("login")) {
					login();
				}
				else if(str.equals("new user")) {
					createUser();
				}
				else if(str.equals("exit")) {
					scan.close();
					System.exit(0);
				}
				else if(str.equals("new admin user")) {
					createAdminUser();
				}
				else {
					System.out.println("Invalid entry, please type 'login' or 'create account'");
					continue;
				}
				x=false;
			}while(x);
			boolean y=true;
			System.out.println("Welcome to your account, Please type an action from the list below");
			do {
				curUser.getStatus();
				if(!getCurUser().isApproved()) {
					System.out.println("You are not yet approved, please wait for admin approval");
					curUserID =-1;
					curUser=null;
					break;
				}
				System.out.println("Actions - 'logout', 'create savings account', 'create credit account', 'create checking account', 'view my accounts', 'deposit', 'withdraw', 'exit'");
				if(curUser.getType().equals("Admin")) {
					System.out.println("Admin Actions - 'view all accounts', 'view all users', 'view unapproved users', 'approve user', 'approve all users', 'change credit limit'");
				}
				String str= scan.nextLine();
				int scanI;
				if(curUser.getType().equals("Admin")) {
					if(str.equals("view all accounts")) {
						System.out.print("Accounts: ");
						for(Account a:accountList) {
							System.out.print(a.getAccountID()+", ");
						}
						System.out.println();
					}
					else if(str.equals("view all users")) {
						System.out.print("Users: ");
						for(Users u: usersList) {
							System.out.print(u.getID()+", ");
						}
						System.out.println();
					}
					else if(str.equals("view unapproved users")) {
						System.out.print("Unapproved users: ");
						for(Users u:unApproved) {
							System.out.print(u.getID()+", ");
						}
						System.out.println();
					}
					else if(str.equals("approve user")) {
						System.out.println("Enter ID of user to approve");
						scanI = scan.nextInt();
						for(Users u:unApproved) {
							if(u.getID()==scanI) {
								u.setApproved(true);
								unApproved.remove(u);
								break;
							}
						}
					}
					else if(str.equals("approve all users")) {
						for(Users u:unApproved) {
							u.setApproved(true);
						}
						unApproved.clear();
					}
					else if(str.equals("change credit limit")) {
						System.out.println("Enter accountID of the credit account");
						scanI = scan.nextInt();
						for(Account a: accountList) {
							if(a.getAccountID()==scanI) {
								if(a instanceof CreditAccount) {
									System.out.println("Enter limit you want to set for this account");
									scanI = scan.nextInt();
									if(scanI<=500) {
										System.out.println("invalid limit");
									}
									else {
										((CreditAccount) a).setCredit(scanI);
									}
								}
								else {
									System.out.println("This is not a credit account, try again");
								}
							}
						}
					}
				}
				if(str.equals("view my accounts")) {
					if(getCurAccounts()!=null) {
						for(Account z:getCurAccounts()) {
							z.getInfo();
						}
					}
					else {
						System.out.println("Currently have no accounts");
					}
				}
				else if(str.equals("deposit")) {
					if(getCurAccounts()!=null) {
					System.out.println("Enter accountID to deposit to: ");
					scanI=scan.nextInt();
						for(Account z:getCurAccounts()) {
							if(z.getAccountID()==scanI) {
								System.out.println("enter amount of money to deposit");
								scanI=scan.nextInt();
								z.deposit(scanI);
							}
						}
					}
					else {
						System.out.println("Currently have no accounts");
					}
				}
				else if(str.equals("withdraw")) {
					if(getCurAccounts()!=null) {
						System.out.println("Enter accountID to withdraw: ");
						scanI=scan.nextInt();
							for(Account z:getCurAccounts()) {
								if(z.getAccountID()==scanI) {
									System.out.println("enter amount of money to withdraw");
									scanI=scan.nextInt();
									z.deposit(scanI);
								}
							}
						}
						else {
							System.out.println("Currently have no accounts");
						}
				}
				else if(str.equals("create savings account")) {
					createAccount("savings",getCurUserID());
				}
				else if(str.equals("create checking account")) {
					createAccount("checking",getCurUserID());
				}
				else if(str.equals("create credit account")) {
					createAccount("credit",getCurUserID());
				}
				else if(str.equals("exit")) {
					scan.close();
					System.exit(0);
				}
				else if(str.equals("logout")) {
					curUserID =-1;
					curUser=null;
					y=false;
				}
				else if(getCurUser().getType()!="Admin") {
					System.out.println("Invalid Entry, please type in one of the available actions");
					continue;
				}
			}while(y);
		}
	}
	
	public static void main(String[] args) {
		MyBank x=new MyBank();
		x.run();
	}

}
