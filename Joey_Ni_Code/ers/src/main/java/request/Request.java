package request;
/**
 * Request BEAN class defines:
 * int rid(PK), float amount, String purpose, int rmid, int reid, int status(FK);
 * defines methods: constructors, getters and setters for fields, toString(), equals(), and hashCode()
 * @author joeyi
 *
 */
public class Request {
	private int rid; //PK
	private float amount;
	private String purpose;
	private int rmid; //Reviewer mid, foreign key to Manager
	private int reid; //Requestor eid, foreign key to Employee
	private int status; //int maps to Enum type on database(FK to status table), of type tinyInt
	
	
	
	public Request(int rid, float amount, String purpose, int rmid, int reid, int status) {
		super();
		this.rid = rid;
		this.amount = amount;
		this.purpose = purpose;
		this.rmid = rmid;
		this.reid = reid;
		this.status = status;
	}



	public int getRid() {
		return rid;
	}



	public void setRid(int rid) {
		this.rid = rid;
	}



	public float getAmount() {
		return amount;
	}



	public void setAmount(float amount) {
		this.amount = amount;
	}



	public String getPurpose() {
		return purpose;
	}



	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}



	public int getRmid() {
		return rmid;
	}



	public void setRmid(int rmid) {
		this.rmid = rmid;
	}



	public int getReid() {
		return reid;
	}



	public void setReid(int reid) {
		this.reid = reid;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + reid;
		result = prime * result + rid;
		result = prime * result + rmid;
		result = prime * result + status;
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
		Request other = (Request) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (reid != other.reid)
			return false;
		if (rid != other.rid)
			return false;
		if (rmid != other.rmid)
			return false;
		if (status != other.status)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Request [rid=" + rid + ", amount=" + amount + ", purpose=" + purpose + ", rmid=" + rmid + ", reid="
				+ reid + ", status=" + status + "]";
	}
	
	
}
