package model;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by bryanvillegas on 4/19/18.
 */
public class Requests {
    private int requestID;
    private double amount;
    private String purpose;
    private int requestFromID, approvedFromID;
    private boolean isApproved;


    public Requests(){}
    public Requests(int rq, String purpose, double a, int rfrom, int afrom, boolean isA){
        this.requestID = rq;
        this.amount = a;
        this.requestFromID = rfrom;
        this.approvedFromID = afrom;
        this.isApproved = isA;
        this.purpose = purpose;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getRequestFromID() {
        return requestFromID;
    }

    public void setRequestFromID(int requestFromID) {
        this.requestFromID = requestFromID;
    }

    public int getApprovedFromID() {
        return approvedFromID;
    }

    public void setApprovedFromID(int approvedFromID) {
        this.approvedFromID = approvedFromID;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getPurpose(){
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
