package accounts;

public class SavingsAccount extends Account{
	private int accountID;

	public SavingsAccount(double money) {
		super(money);
		setAccountID(super.getCurAccountNum());
		super.setCurAccountNum();
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

}
