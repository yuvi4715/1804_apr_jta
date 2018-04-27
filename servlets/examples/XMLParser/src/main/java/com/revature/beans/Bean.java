package com.revature.beans;

public class Bean {
	private String name;
	private String strain;
	private int yield;
	private double mass;
	private boolean tasty;
	public Bean() {
		super();
	}
	public Bean(String name, String strain, int yeild, double mass, boolean tasty) {
		super();
		this.name = name;
		this.strain = strain;
		this.yield = yeild;
		this.mass = mass;
		this.tasty = tasty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	public int getYield() {
		return yield;
	}
	public void setYield(int yield) {
		this.yield = yield;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public boolean isTasty() {
		return tasty;
	}
	public void setTasty(boolean tasty) {
		this.tasty = tasty;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(mass);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((strain == null) ? 0 : strain.hashCode());
		result = prime * result + (tasty ? 1231 : 1237);
		result = prime * result + yield;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bean other = (Bean) obj;
		if (Double.doubleToLongBits(mass) != Double.doubleToLongBits(other.mass))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strain == null) {
			if (other.strain != null)
				return false;
		} else if (!strain.equals(other.strain))
			return false;
		if (tasty != other.tasty)
			return false;
		if (yield != other.yield)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bean [name=" + name + ", strain=" + strain + ", yeild=" + yield + ", mass=" + mass + ", tasty=" + tasty
				+ "]";
	}	
}
