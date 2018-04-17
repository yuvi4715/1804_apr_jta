package joey.bank.model;

import java.util.List;

/**
 * BankAccount interface for BankAccount view of the db
 * @author joeyi
 *
 */
public interface BankAccountInterface {
	void createAccount(BankUser user);
	int getAccountNumber(BankUser user);
	float deposit(int acct, float balance);
	float getBalance(int account);
	float withdraw(int account, float amount);
	int getAccountNumber(int id);
	
}
