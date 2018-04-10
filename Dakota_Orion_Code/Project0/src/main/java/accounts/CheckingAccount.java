package accounts;

public class CheckingAccount extends Account{
	private int accountID;

	public CheckingAccount(double money) {
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
