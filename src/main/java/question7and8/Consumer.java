package question7;

public class Consumer {
	private static int allMoney=0;
	int money=100;
	final String name="John Doe";
	
	public Consumer(int cash) {
		money = cash;
		allMoney=allMoney+cash;
	}
	
	public Consumer() {
		money=money+100;
		allMoney+=100;
	}
	
	void addMoney() {
		money+=100;
		allMoney+=100;
	}
	
	void subMoney(int amount) {
		if(amount<money) {
			money=money-amount;
		}
		else {System.out.println("Not Enough Money");}
	}
	static int getAllMoney() {
		return allMoney;
	}
	
	static void setAllMoney(int sMoney) {
		allMoney=sMoney;
	}
	
	void addMoney(int cash) {
		money=money+cash;
		allMoney+=cash;
	}
	
	void subMoney() {
		allMoney-=money;
		money=0;
	}
}
