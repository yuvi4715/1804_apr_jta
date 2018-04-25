package main.Model;

import java.sql.Date;

public class Reimbursement {
	private int ID;
	private String email;
	private String status;
	private double amount;
	private String manager;
	private String purpose;
	private Date requested;
	private Date approved;

	public Reimbursement(int newid, String e, String s, double a, String m, String p, Date r, Date appdate) 
	{
		ID = newid;
		email = e;
		status = s;
		amount = a;
		manager = m;
		purpose = p;
		requested = r;
		approved = appdate;
	}

	public int getID() 
	{
		return ID;
	}

	public void setID(int newid) 
	{
		ID = newid;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String e) 
	{
		email = e;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String s) 
	{
		status = s;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double a)
	{
		amount = a;
	}

	public String getManager() 
	{
		return manager;
	}

	public void setManager(String m) 
	{
		manager = m;
	}
	
	public String getPurpose()
	{
		return purpose;
	}
	
	public void setPurpose(String p)
	{
		purpose = p;
	}
	
	public Date getRequestDate()
	{
		return requested;
	}
	
	public void setRequestDate(Date r)
	{
		requested = r;
	}
	
	public Date getApprovedDate()
	{
		return approved;
	}
	
	public void setApprovedDate(Date a)
	{
		approved = a;
	}
}
