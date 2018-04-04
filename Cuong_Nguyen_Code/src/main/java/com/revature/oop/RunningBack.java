package com.revature.oop;

public abstract class RunningBack implements Player {
	public void run()
	{
		System.out.println("RB can run");
	}
	public void canCatch() {
		System.out.println("RB's can definitely catch");
	}
	
	public void handOffs()
	{
		System.out.println("RB's get hand offs");
	}
	
	abstract void rush();
	
}
