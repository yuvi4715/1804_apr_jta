package com.revature.inclass.oop;

public interface Player {
	void run();

	void canCatch();

	void tackle();

	void hurdle();

	void handoff();

	void block();

	default void jump() {
		System.out.println("le jump");
	}
	default void status() {
		System.out.println("Red shirt, hurt, active, resrve");
	}
}
