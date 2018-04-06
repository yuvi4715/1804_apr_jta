package com.revature.oop;

public class QuarterBack implements Player {

	@Override
	public void run() {
		System.out.println("DeShawn Watson knows to run");
	}

	@Override
	public void throwBall() {
		System.out.println("Peyton Manning knows to throw");
	}

	@Override
	public void canCatch() {
		System.out.println("Nick can catch");
	}

	@Override
	public void tackle() {
		System.out.println("Russell Wilson can tackle");
	}

	@Override
	public void hurdle() {
		System.out.println("Cam Newton does hurdle");
	}

	@Override
	public void handOffs() {
		System.out.println("All QBs are good at handoffs");
	}

	@Override
	public void block() {
		System.out.println("Rogers got injured while blocking");
	}

}
