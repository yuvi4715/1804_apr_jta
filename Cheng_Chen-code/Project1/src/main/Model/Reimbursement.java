package main.Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Reimbursement 
{
	int ID;
	String email;
	String status;
	double amount;
	String manager;
	String purpose;
	Date requested;
	Date approved;
	String requestDate;
	String viewDate;
	
	//FOR NEW REQUESTS
	public Reimbursement(double a, String requester, String p)
	{
		amount = a;
		email = requester;
		purpose = p;
	}
	
	
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
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
		if(this.requested != null)
			requestDate = df.format(this.requested);
		
		if(this.approved != null)
			viewDate = df.format(this.approved);
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
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		viewDate = df.format(this.approved);
	}
}
