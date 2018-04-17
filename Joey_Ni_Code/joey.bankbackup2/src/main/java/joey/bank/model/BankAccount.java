package joey.bank.model;

public class BankAccount
{
	private int account_number;
	private float account_balance;
	
	
	@Override
	public String toString() {
		return "BankAccount [account_number=" + account_number + ", account_balance=" + account_balance + "]";
	}
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(int account_number, float account_balance) {
		super();
		this.account_number = account_number;
		this.account_balance = account_balance;
	}
	
	public BankAccount(int account_number) {
		super();
		this.account_number = account_number;
		this.account_balance = 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(account_balance);
		result = prime * result + account_number;
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
		BankAccount other = (BankAccount) obj;
		if (Float.floatToIntBits(account_balance) != Float.floatToIntBits(other.account_balance))
			return false;
		if (account_number != other.account_number)
			return false;
		return true;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public float getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(float account_balance) {
		this.account_balance = account_balance;
	}
	
	
	
}
