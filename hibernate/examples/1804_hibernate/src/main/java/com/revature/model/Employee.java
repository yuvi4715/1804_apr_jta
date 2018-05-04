package com.revature.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@NamedQueries({
	@NamedQuery(name="RetrieveAllEmployees", query="from Employee")
	})
//@NamedNativeQueries({
//	@NamedNativeQuery(name="RetrieveEmployeeById", 
//			query="select * from employee where id =:")
//})

//Native SQL is nothing but regular SQL
//Native SQL is not encouraged because its tied with one database vendor
public class Employee {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqname")
	@SequenceGenerator(initialValue=1, sequenceName="seq_name", allocationSize=1, name="seqname")
	
	@Column(name="E_ID", nullable=false)
	private int eid;
	
	@Column(name="E_NAME", length=40)
	private String ename;
	
	@Column(name="E_TITLE", length=40)
	private String etitle;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="CREATED_BY", length=40)
	private String createdBy;
	
	
	public Employee() {
		super();
	}
	public Employee(int eid, String ename, String etitle, Date createdDate, String createdBy) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.etitle = etitle;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	public Employee(String ename, String etitle, Date createdDate, String createdBy) {
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
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", etitle=" + etitle + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + eid;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + ((etitle == null) ? 0 : etitle.hashCode());
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
		Employee other = (Employee) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (eid != other.eid)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (etitle == null) {
			if (other.etitle != null)
				return false;
		} else if (!etitle.equals(other.etitle))
			return false;
		return true;
	}
	
	
}
