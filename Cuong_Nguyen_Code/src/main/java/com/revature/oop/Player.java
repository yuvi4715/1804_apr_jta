package com.revature.oop;

public interface Player {
	//abstract methods
	//contains default and static methods
	
	void run();
	void throwBall();
	void canCatch();
	void tackle();
	void hurdle();
	void handOffs();
	void block();
	
	default void jump() {
		System.out.println("Players know to jump");
	}
	
	static void status() {
		System.out.println("Player m aybe active or on bench or injured");
	}
}
