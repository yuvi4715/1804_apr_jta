package Bank.model;

/**
 * Created by bryanvillegas on 4/10/18.
 */
public class Accounts {
    private int accountID;
    private double moneyAmount;

    public Accounts(){}
    public Accounts(int accountID, double moneyAmount){
        this.accountID = accountID;
        this.moneyAmount = moneyAmount;
    }
    public double getMoneyAmount(){
        return moneyAmount;
    }
    public double setMoneyAmount(double moneyAmount){
        return this.moneyAmount = moneyAmount;
    }


    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
