//John Eifert
package accounts;



public interface Transactable
{
	abstract public boolean deposit(long amount);
	
	abstract public boolean withdraw(long amount);
}
