package com.revature.oop;

public interface Player {

		//abstract methods
	//contain default and static methods
	void run();
	void throwBall();
	void canCatch();
	void hurdle();
	void handOffs();
	void block();
	default void jump() {
		System.out.println("Players jump");
	}
	
	static void status() {
		System.out.println("Player may be active or on bench or injured");
	}
}
