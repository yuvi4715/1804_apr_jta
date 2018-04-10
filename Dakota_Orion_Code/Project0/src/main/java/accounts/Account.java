package accounts;

public abstract class Account{
	private static int curAccountNum=1;
	String status ="Active";
	double accountBalance;
	
	public Account(double money){
		accountBalance=money;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getCurAccountNum() {
		return curAccountNum;
	}
	
	public void setCurAccountNum() {
		curAccountNum++;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void deposit(int money) {
		accountBalance+=money;
	}
	
	public void withdraw(int money) {
		accountBalance-=money;
	}
	
	public void deleteAccount() {
		accountBalance=0;
		status = "StandBy";
	}

	
}
