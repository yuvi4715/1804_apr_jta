package joey.bank.model;

/**
 * BankUser interface that defines the standard operations to be performed on a BankUser model object
 * @author joeyi
 *
 */
public interface BankUserInterface 
{
	BankUser getUser(String lastname, String firstname);
	boolean deposit(float amount);
	boolean withdraw(float amount);
	float getBalance(String username, String password);
	
}
