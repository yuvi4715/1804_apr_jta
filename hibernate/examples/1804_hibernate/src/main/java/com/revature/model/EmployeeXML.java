package com.revature.model;

import java.util.Date;

public class EmployeeXML {

	private int eid;
	private String ename;
	private String etitle;
	private Date createdDate;
	private String createdBy;
	
	public EmployeeXML() {
		super();
	}
	
	
	public EmployeeXML(String ename, String etitle, Date createdDate, String createdBy) {
		super();
		this.ename = ename;
		this.etitle = etitle;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}


	public EmployeeXML(int eid, String ename, String etitle, Date createdDate, String createdBy) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.etitle = etitle;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
}
