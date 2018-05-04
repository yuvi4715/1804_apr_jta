package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeAnn")
public class EmployeeAnn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqname")
	@SequenceGenerator(initialValue=1, sequenceName="seq_name", allocationSize=100, name="seqname")
	
	@Column(name="EA_ID", nullable=false)
	private int eid;
	
	@Column(name="E_NAME", length=40)
	private String ename;
	
	@Column(name="E_TITLE", length=40)
	private String etitle;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="CREATED_BY", length=40)
	private String createdBy;
	
	public EmployeeAnn(int eid, String ename, String etitle, Date createdDate, String createdBy) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.etitle = etitle;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	public EmployeeAnn(String ename, String etitle, Date createdDate, String createdBy) {
		super();
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
