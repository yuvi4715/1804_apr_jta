package question7and8;

public class q7and8{
	public static void main(String[] args) {
		Consumer JD1 = new Consumer();
		Consumer JD2 = new Consumer(400);
		JD1.addMoney();
		System.out.println("JD1 Money: " + JD1.money);
		JD2.addMoney(300);
		System.out.println("JD2 Money: " + JD2.money);
		System.out.println("All Money: " + Consumer.getAllMoney());
		JD1.subMoney();
		System.out.println("JD1 Money: " + JD1.money);
		System.out.println("JD2 Money: " + JD2.money);
		JD2.subMoney(200);
		System.out.println("JD2 Money: " + JD2.money);
		Consumer.setAllMoney(200);
		System.out.println("All Money: " + Consumer.getAllMoney());
		Consumer.setAllMoney(JD2.money+JD1.money);
		System.out.println("All Money: " + Consumer.getAllMoney());
	}
}
