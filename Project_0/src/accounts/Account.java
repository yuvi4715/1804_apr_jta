//John Eifert
package accounts;



abstract public class Account
{
	protected String holder;
	protected String password;
	protected long acctNumber;
	protected int approved;
	
	
	public String getHolder()
	{
		return(this.holder);
	}
	public String getPassword()
	{
		return(this.password);
	}
	public long getAcctNumber()
	{
		return(this.acctNumber);
	}
	public int getApproved()
	{
		return(this.approved);
	}
}
