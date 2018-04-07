package com.revature.oop;

public abstract class RunningBack implements Player{
	public abstract void run();
	public void canCatch() {
		System.out.println("Rb's can jump");
	}
	
	public void handOffs() {
		System.out.println("RB's get handouts");
	}
}
