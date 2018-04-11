package accounts;

public class CreditAccount extends Account{
	private double credit;
	private double availableCredit;
	private int accountID;

	public CreditAccount(double limit) {
		super(limit);
		setCredit(limit);
		setAvailableCredit(limit);
		setAccountID(super.getCurAccountNum());
		super.setCurAccountNum();
	}
	
	public void deposit(int money) {
		setAvailableCredit(getAvailableCredit() + money);
	}
	
	public void withdraw(int money) {
		setAvailableCredit(getAvailableCredit()-money);
	}

	public double getAvailableCredit() {
		return availableCredit;
	}

	public void setAvailableCredit(double availableCredit) {
		this.availableCredit = availableCredit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public int getAccountID() {
		return accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public void getInfo() {
		System.out.println("accountID: "+ getAccountID());
		System.out.println("Status: " + super.getStatus());
		System.out.println("Credit Limit: "+getCredit());
		System.out.println("Available Credit: "+ getAvailableCredit());
		System.out.println("Account type: credit");
	}
}
