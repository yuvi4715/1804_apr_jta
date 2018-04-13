package accounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import model.AccountBean;
import model.Service;
import model.UsersBean;

public class MyBank {
	final static Logger log = Logger.getLogger(MyBank.class);

	private ArrayList<AccountBean> curAccounts= new ArrayList<AccountBean>();
	Scanner scan = new Scanner(System.in);
	private int curUserID;
	private UsersBean curUser;
	
	public void createUser() {
		System.out.println("Creating Standard User");
		UsersBean nUsers = new UsersBean();
		nUsers.setapprove("False");
		nUsers.settype("User");
		nUsers.setUsersBeanId(Service.getMaxUsersBeanId()+1);
		boolean x=true;
		do {
			System.out.println("Please enter your password");
			String str= scan.nextLine();
			nUsers.setpassword(str);
			System.out.println("Please reenter your password");
			str= scan.nextLine();
			if(nUsers.getpassword().equals(str)) {
				System.out.println("Successfully created an account");
				x=false;
			}
			else {
				System.out.println("Passwords don't match try again");
			}
		}while(x);
		setCurUserID(nUsers.getUsersBeanId());
		setCurUser(nUsers);
		//usersList.add(curUser);
		Service.insertUsersBean(nUsers);
		//allUsers.put(curUserID, nUsers);
		//addUnapproved(nUsers);
		System.out.println("Please wait for an Admin to approve your account");
	}
	/*
	public void addUnapproved(Users user) {
		unApproved.add(user);
		for(int i=0;i<unApproved.size();i++) {
			if(unApproved.get(i).isApproved()==true) {
				unApproved.remove(i);
			}
		}
	}*/
	
	public void createAdminUser() {
		System.out.println("Creating Admin User");
		UsersBean nUsers = new UsersBean();
		nUsers.setUsersBeanId(Service.getMaxUsersBeanId()+1);
		nUsers.setapprove("True");
		nUsers.settype("Admin");
		boolean x=true;
		do {
			System.out.println("Please enter your password");
			String str= scan.nextLine();
			nUsers.setpassword(str);
			System.out.println("Please reenter your password");
			str= scan.nextLine();
			if(nUsers.getpassword().equals(str)) {
				System.out.println("Successfully created an account");
				x=false;
			}
			else {
				System.out.println("Passwords don't match try again");
			}
		}while(x);
		setCurUserID(nUsers.getUsersBeanId());
		setCurUser(nUsers);
		Service.insertUsersBean(nUsers);
		//usersList.add(getCurUser());
		//allUsers.put(getCurUserID(), nUsers);
	}
	
	public void createAccount(String str, int userID) {
		int id = Service.getMaxAccountsBeanId()+1;
		AccountBean acc = new AccountBean("Active",0, 0,str);
		if(str.equals("Credit")) {
			acc.setLimit(1000);
		}
		acc.setAccountBeanId(id);
		Service.insertAccountsBean(acc);;
		Service.createUserAccountRelationship(getCurUserID(), acc.getAccountBeanId());
		curAccounts.add(acc);
	}
	
	public UsersBean getCurUser() {
		return curUser;
	}

	public void setCurUser(UsersBean nUsers) {
		this.curUser = nUsers;
	}
	
	public void login() {
		boolean x=true;
		do {
			System.out.println("Enter your userID or '0' to create new user");
			int userID;
			try{userID = scan.nextInt();}
			catch(Exception e) {
				System.out.println("What you entered is not an integer");
				System.out.println(e.getMessage());
				log.error("Invalid input, expecting an integer");
				scan.next();
				continue;
			}
			setCurUserID(userID);
			UsersBean temp = Service.getUsersBean(userID);
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
			else if(temp==null) {
				System.out.println("Invalid ID");
				continue;
			}
			System.out.println("Enter your password");
			String str = scan.nextLine();
			str = scan.nextLine();
			if(str.equals(temp.getpassword())==false) {
				System.out.println("Incorrect Password");
				continue;
			}
			temp.setUsersBeanId(curUserID);
			setCurUser(temp);
			curAccounts.clear();
			for(int i:Service.getUserAccounts(getCurUserID())) {
				AccountBean atemp = Service.getAccountBean(i);
				atemp.setAccountBeanId(i);
				curAccounts.add(atemp);
			}
			x=false;
		}while(x);
	}

	public int getCurUserID() {
		return curUserID;
	}

	public void setCurUserID(int curUserID) {
		this.curUserID = curUserID;
	}
	
	public ArrayList<AccountBean> getCurAccounts() {
		return curAccounts;
	}

	public void setCurAccounts(ArrayList<AccountBean> curAccounts) {
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
				System.out.println("My "+getCurUser().toString());
				if(getCurUser().getapprove().equals("False")) {
					System.out.println("You are not yet approved, please wait for admin approval");
					curUserID =-1;
					curUser=null;
					break;
				}
				System.out.println("Actions - 'logout', 'create savings account', 'create credit account', 'create checking account', 'view my accounts', 'deposit', 'withdraw', 'exit'");
				if(curUser.gettype().equals("Admin")) {
					System.out.println("Admin Actions - 'view all accounts', 'view all users', 'view unapproved users', 'approve user', 'approve all users', 'change credit limit'");
				}
				String str= scan.nextLine();
				int scanI;
				if(curUser.gettype().equals("Admin")) {
					if(str.equals("view all accounts")) {
						System.out.print("Accounts: ");
						List<AccountBean> accounts = Service.getAllAccountsBeans();
						for(AccountBean a:accounts) {
							System.out.println(a);
						}
					}
					else if(str.equals("view all users")) {
						System.out.print("Users: ");
						List<UsersBean> users = Service.getAllUsersBean();
						for(UsersBean u: users) {
							System.out.println(u+", ");
						}
					}
					else if(str.equals("view unapproved users")) {
						System.out.print("Unapproved users: ");
						List<UsersBean> users = Service.getAllUsersBean();
						for(UsersBean u:users) {
							if(u.getapprove().equals("False")) {
								System.out.println(u);
							}
						}
					}
					else if(str.equals("approve user")) {
						System.out.println("Enter ID of user to approve");
						try{scanI = scan.nextInt();}
						catch(Exception e) {
							System.out.println("What you entered is not an integer");
							System.out.println(e.getMessage());
							log.error("Invalid input, expecting an integer");
							scan.next();
							continue;
						}
						UsersBean user = Service.getUsersBean(scanI);
						if(user!=null) {
							user.setapprove("True");
							Service.updateUsersBean(user);
						}
						else {
							System.out.println("No user with that ID");
						}
					}
					else if(str.equals("approve all users")) {
						List<UsersBean> users = Service.getAllUsersBean();
						for(UsersBean u:users) {
							if(u.getapprove().equals("False")) {
								u.setapprove("True");
								Service.updateUsersBean(u);
							}
						}
					}
					else if(str.equals("change credit limit")) {
						System.out.println("Enter accountID of the credit account");
						try{scanI = scan.nextInt();}
						catch(Exception e) {
							System.out.println("What you entered is not an integer");
							System.out.println(e.getMessage());
							log.error("Invalid input, expecting an integer");
							scan.next();
							continue;
						}
						AccountBean acc =Service.getAccountBean(scanI);
						if(acc.getType().equals("Credit")) {
							System.out.println("Enter limit you want to set for this account");
							try{scanI = scan.nextInt();}
							catch(Exception e) {
								System.out.println("What you entered is not an integer");
								System.out.println(e.getMessage());
								log.error("Invalid input, expecting an integer");
								scan.next();
								continue;
							}
							if(scanI<=500) {
								System.out.println("invalid limit, limit must be over $500");
							}
							else {
								acc.setLimit(scanI);
								Service.updateAccountsBean(acc);
							}
						}
						else {
							System.out.println("This account is not a credit account");
						}
					}
				}
				if(str.equals("view my accounts")) {
					curAccounts.clear();
					for(int i:Service.getUserAccounts(getCurUserID())) {
						AccountBean atemp = Service.getAccountBean(i);
						atemp.setAccountBeanId(i);
						curAccounts.add(atemp);
						System.out.println(atemp);
					}
				}
				else if(str.equals("deposit")) {
					if(getCurAccounts()!=null) {
					System.out.println("Enter accountID to deposit to: ");
					System.out.println("Money will fail to deposit if accountID does not correlate to your account");
					try{scanI = scan.nextInt();}
					catch(Exception e) {
						System.out.println("What you entered is not an integer");
						log.error("Invalid input, expecting an integer");
						scan.next();
						continue;
					}
						for(AccountBean z:getCurAccounts()) {
							if(z.getAccountBeanId()==scanI) {
								System.out.println("enter amount of money to deposit");
								try{scanI = scan.nextInt();}
								catch(Exception e) {
									System.out.println("What you entered is not an integer");
									System.out.println(e.getMessage());
									log.error("Invalid input, expecting an integer");
									scan.next();
								}
								if(z.getType().equals("Credit")) {
									z.setBalance(z.getBalance()-scanI);
									Service.updateAccountsBean(z);
								}
								else {
									z.setBalance(z.getBalance()+scanI);
									Service.updateAccountsBean(z);
								}
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
						System.out.println("Money will fail to withdraw if accountID does not correlate to your account");
						try{scanI = scan.nextInt();}
						catch(Exception e) {
							System.out.println("What you entered is not an integer");
							System.out.println(e.getMessage());
							log.error("Invalid input, expecting an integer");
							scan.next();
							continue;
						}
							for(AccountBean z:getCurAccounts()) {
								if(z.getAccountBeanId()==scanI) {
									System.out.println("enter amount of money to withdraw");
									try{scanI = scan.nextInt();}
									catch(Exception e) {
										System.out.println("What you entered is not an integer");
										System.out.println(e.getMessage());
										log.error("Invalid input, expecting an integer");
										scan.next();
									}
									if(z.getType().equals("Credit")) {
										if(z.getBalance()+scanI>z.getLimit()) {
											System.out.println("You don't have enought credit to do this");
										}
										else {
											z.setBalance(z.getBalance()+scanI);
											Service.updateAccountsBean(z);
										}
									}
									else {
										if(z.getBalance()>=scanI) {
											z.setBalance(z.getBalance()-scanI);;
											Service.updateAccountsBean(z);
										}
										else {
											System.out.println("You don't have enought money to do this");
										}
									}
								}
							}
						}
						else {
							System.out.println("Currently have no accounts");
						}
				}
				else if(str.equals("create savings account")) {
					createAccount("Savings",getCurUserID());
				}
				else if(str.equals("create checking account")) {
					createAccount("Checking",getCurUserID());
				}
				else if(str.equals("create credit account")) {
					createAccount("Credit",getCurUserID());
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
				else if(!(getCurUser().gettype().equals("Admin"))) {
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
